package com.example.userlist.model.comics


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("available")
    val available: String,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("returned")
    val returned: String
)