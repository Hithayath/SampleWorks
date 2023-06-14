package com.sample.myapplication.datalayer.network

import com.sample.myapplication.datalayer.network.models.NetworkListData

interface NetworkDataSource {
    suspend fun getNetworkListData(): List<NetworkListData>
}