package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import kotlinx.coroutines.flow.Flow

interface ListRepository {
    /**
     * Gets the available list as a stream
     */
    fun getListsStream(): Flow<List<ListData>>
}