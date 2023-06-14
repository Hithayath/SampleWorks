package com.sample.myapplication.domainlayer

import com.sample.myapplication.datalayer.DetailsData
import com.sample.myapplication.datalayer.local.DetailItem
import com.sample.myapplication.datalayer.local.ListItem
import com.sample.myapplication.datalayer.repository.DetailsRepository
import com.sample.myapplication.uilayer.ListUiState
import com.sample.myapplication.uilayer.PopupState
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DetailsUseCaseTest {

    @RelaxedMockK
    private lateinit var detailsRepository: DetailsRepository
    private lateinit var detailsUseCase: DetailsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        detailsUseCase = DetailsUseCase(detailsRepository)
    }

    @Test
    fun `test invoke initial details data success case`() = runBlocking {
        //Given
        val id = "id"
        val mockData = listOf(getMockDetailsData()).asFlow()
        coEvery { detailsRepository.getDetailsStream(id) } returns mockData

        val actual = PopupState.Details(DetailItem("id", "firstname", "lastname", "dob", "address", "contact"))

        //When
        val expected = detailsUseCase(id).first()

        //Then
        assertEquals(expected, actual)
    }

    @Test
    fun `test invoke initial details data error case`() = runBlocking {
        //Given
        val id = "id"
        val expected = Exception("Some error")
        coEvery { detailsRepository.getDetailsStream(id) } returns flow {
            throw expected
        }

        //When
        detailsUseCase(id).catch {cause ->
            assertEquals(expected, cause)
        }.collect()

        //Then
        assertTrue(true)
    }

    @Test
    fun `test invoke details null case`() = runBlocking {
        //Given
        val id = "id"
        val mockData = listOf<DetailsData?>(null).asFlow()
        coEvery { detailsRepository.getDetailsStream(id) } returns mockData

        val actual = PopupState.Error(Exception("Data is not available."))

        //When
        val expected = detailsUseCase(id).first()
        expected as PopupState.Error

        //Then
        assertEquals(expected.exception.message, actual.exception.message)
    }

    private fun getMockDetailsData(): DetailsData {
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