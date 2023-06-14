package com.sample.myapplication.datalayer.network.retrofit

import com.sample.myapplication.BuildConfig
import com.sample.myapplication.datalayer.network.NetworkDataSource
import com.sample.myapplication.datalayer.network.models.NetworkListData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitNetworkApi {
    @GET(value = "lists")
    suspend fun getNetworkListData(): NetworkResponse<List<NetworkListData>>
}

private const val baseUrl = BuildConfig.BACKEND_URL

private data class NetworkResponse<T>(
    val data: T
)

@Singleton
class RetrofitNetwork @Inject constructor(
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun getNetworkListData(): List<NetworkListData> =
        networkApi.getNetworkListData().data
}