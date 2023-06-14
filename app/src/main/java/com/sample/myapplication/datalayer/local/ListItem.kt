package com.sample.myapplication.datalayer.local

data class ListItem(
    val id: String,
    val name: String,
    val about: String
)

data class DetailItem(
    val id: String,
    val firstName: String,
    val lastName: String,
    val dob: String,
    val address: String,
    val phone: String
)
