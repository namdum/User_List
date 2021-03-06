package com.example.userlist.model.chars


import com.google.gson.annotations.SerializedName

data class Events(
  @SerializedName("available")
    val available: String,
  @SerializedName("collectionURI")
    val collectionURI: String,
  @SerializedName("items")
    val items: List<ItemX>,
  @SerializedName("returned")
    val returned: String
)