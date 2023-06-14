package com.sample.myapplication.uilayer.viewmodels

import com.sample.myapplication.MainCoroutineRule
import com.sample.myapplication.datalayer.local.DetailItem
import com.sample.myapplication.domainlayer.DetailsUseCase
import com.sample.myapplication.domainlayer.ListUseCase
import com.sample.myapplication.uilayer.ListUiState
import com.sample.myapplication.uilayer.PopupState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.*

@OptIn(ExperimentalCoroutinesApi::class)
class ListViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @RelaxedMockK
    private lateinit var listUseCase: ListUseCase
    @RelaxedMockK
    private lateinit var detailsUseCase: DetailsUseCase

    private lateinit var viewModel: ListViewModel
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = ListViewModel(listUseCase, detailsUseCase)
    }

    @Test
    fun `test fetchList to get list of data and no data result case`() = runTest {
        //Given
        val expected = ListUiState.NoData
        coEvery { listUseCase() } returns flowOf(expected)

        //When
        viewModel.fetchList()
        advanceUntilIdle()
        val listUiState = viewModel.listUiState.value

        //Then
        Assert.assertEquals(expected, listUiState)
    }

    @Test
    fun `test fetchList to get list of data and error result case`() = runTest {
        //Given
        val expected = ListUiState.Error(Exception("some error"))
        coEvery { listUseCase() } returns flowOf(expected)

        //When
        viewModel.fetchList()
        advanceUntilIdle()
        val listUiState = viewModel.listUiState.value

        //Then
        Assert.assertEquals(expected, listUiState)
    }

    @Test
    fun `test fetchList to get list of data success case`() = runTest {
        //Given
        val expected = ListUiState.Items(listOf())
        coEvery { listUseCase() } returns flowOf(expected)

        //When
        viewModel.fetchList()
        advanceUntilIdle()
        val listUiState = viewModel.listUiState.value

        //Then
        Assert.assertEquals(expected, listUiState)
    }

    @Test
    fun `test getDetails to get particular data for the id no data result case`() = runTest {
        //Given
        val id = "id"
        val expected = PopupState.Error(Exception("No data"))
        every { detailsUseCase(id) } returns flowOf(expected)

        //When
        viewModel.getDetails(id)
        advanceUntilIdle()
        val popupState = viewModel.popupState.value
        runCurrent()
        //Then
        Assert.assertEquals(expected, popupState)
    }

    @Test
    fun `test getDetails to get particular data for the id error result case`() = runTest {
        //Given
        val id = "id"
        val expected = PopupState.Error(Exception("some error"))
        coEvery { detailsUseCase(id) } returns flowOf(expected)

        //When
        viewModel.getDetails(id)
        advanceUntilIdle()
        val popupState = viewModel.popupState.value

        //Then
        Assert.assertEquals(expected, popupState)
    }

    @Test
    fun `test getDetails to get particular data for the id success case`() = runTest {
        //Given
        val id = "id"
        val expected = PopupState.Details(DetailItem("id", "firstname", "lastname",
            "dob", "address", "contact"))
        coEvery { detailsUseCase(id) } returns flowOf(expected)

        //When
        viewModel.getDetails(id)
        advanceUntilIdle()
        val popupState = viewModel.popupState.value

        //Then
        Assert.assertEquals(expected, popupState)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}