package com.example.userlist.model.chars


import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)