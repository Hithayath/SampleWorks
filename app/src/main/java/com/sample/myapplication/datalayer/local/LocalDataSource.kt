package com.sample.myapplication.datalayer.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.myapplication.datalayer.ListData
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

interface LocalDataSource {
    suspend fun getListData(): List<ListData>
}

@Singleton
class MockDataSource @Inject constructor(
) : LocalDataSource {
    private val mockListData = mutableListOf<ListData>()

    override suspend fun getListData(): List<ListData> {
        mockListData.addAll(getUserData())
        return mockListData
    }

    private fun getUserData(): List<ListData> {
        val json = """
        [
            {
             "id": "id1",
             "firstName": "Abraham",
             "lastName": "Lincoln",
             "dob": "21/01/1981",
             "address": "Street 1, Road 1, City 1",
             "contact": "+1411111111"
            },
            {
             "id": "id2",
             "firstName": "Big",
             "lastName": "Brother",
             "dob": "25/02/1982",
             "address": "Street 2, Road 2, City 2",
             "contact": "+14222222"
            },
            {
             "id": "id3",
             "firstName": "Cadin",
             "lastName": "David",
             "dob": "25/03/1983",
             "address": "Street 3, Road 3, City 3",
             "contact": "+14333333"
            },
            {
             "id": "id4",
             "firstName": "David",
             "lastName": "Warner",
             "dob": "25/02/1984",
             "address": "Street 4, Road 4, City 4",
             "contact": "+14444444"
            },
            {
             "id": "id5",
             "firstName": "Elizabeth",
             "lastName": "Sister",
             "dob": "25/02/1985",
             "address": "Street 5, Road 5, City 5",
             "contact": "+14555555"
            },
            {
             "id": "id6",
             "firstName": "Frank",
             "lastName": "Vahoun",
             "dob": "25/02/1986",
             "address": "Street 6, Road 6, City 6",
             "contact": "+14666666"
            },
            {
             "id": "id7",
             "firstName": "Gill",
             "lastName": "Christ",
             "dob": "25/07/1987",
             "address": "Street 7, Road 7, City 7",
             "contact": "+147777777"
            },
            {
             "id": "id8",
             "firstName": "Hithayath",
             "lastName": "Muhammad",
             "dob": "25/08/1988",
             "address": "Street 8, Road 8, City 8",
             "contact": "+14888888"
            },
            {
             "id": "id9",
             "firstName": "Imran",
             "lastName": "Khan",
             "dob": "25/09/1989",
             "address": "Street 9, Road 9, City 9",
             "contact": "+14999999"
            },
            {
             "id": "id10",
             "firstName": "Jacob",
             "lastName": "Jensen",
             "dob": "25/10/1990",
             "address": "Street 10, Road 10, City 10",
             "contact": "+14999910"
            }
        ]  """
        val listOfData: Type = object : TypeToken<List<ListData?>?>() {}.type
        return Gson().fromJson<List<ListData>>(json, listOfData)
    }
}