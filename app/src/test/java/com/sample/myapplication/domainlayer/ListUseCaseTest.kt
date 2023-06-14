package com.sample.myapplication.domainlayer

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.local.ListItem
import com.sample.myapplication.datalayer.repository.ListRepository
import com.sample.myapplication.uilayer.ListUiState
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ListUseCaseTest {
    @RelaxedMockK
    private lateinit var listRepository: ListRepository
    private lateinit var listUseCase: ListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        listUseCase = ListUseCase(listRepository)
    }

    @Test
    fun `test invoke initial list data success case`() = runBlocking {
        //Given
        val mockList = listOf(listOf(getMockListData())).asFlow()
        coEvery { listRepository.getListsStream() } returns mockList

        val actual = ListUiState.Items(listOf(ListItem(
            id = "id", name = "firstname lastname", about = "address"
        )))

        //When
        val expected = listUseCase.getList().first()

        //Then
        assertEquals(expected, actual)
    }

    @Test
    fun `test invoke initial list data error case`() = runBlocking {
        //Given
        val expected = Exception("Some error")
        coEvery { listRepository.getListsStream() } returns flow {
            throw expected
        }

        //When
        listUseCase.getList().catch {cause ->
            assertEquals(expected, cause)
        }.collect()

        //Then
        assertTrue(true)
    }

    @Test
    fun `test invoke initial list empty case`() = runBlocking {
        //Given
        val mockList = listOf(emptyList<ListData>()).asFlow()
        coEvery { listRepository.getListsStream() } returns mockList

        val actual = ListUiState.NoData

        //When
        val expected = listUseCase.getList().first()

        //Then
        assertEquals(expected, actual)
    }

    private fun getMockListData(): ListData {
        return mockk {
            every { id } returns "id"
            every { firstName } returns "firstname"
            every { lastName } returns "lastname"
            every { dob } returns "dob"
            every { address } returns "address"
            every { contact } returns "contact"
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}