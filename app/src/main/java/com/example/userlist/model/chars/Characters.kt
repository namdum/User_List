package com.example.userlist.model.chars


import com.google.gson.annotations.SerializedName
import java.io.Serializable

//class Characters : ArrayList<CharModelItem>()

data class Characters(
  @SerializedName("attributionHTML")
    val attributionHTML: String,
  @SerializedName("attributionText")
    val attributionText: String,
  @SerializedName("code")
    val code: String,
  @SerializedName("copyright")
    val copyright: String,
  @SerializedName("data")
    val data: Data,
  @SerializedName("etag")
    val etag: String,
  @SerializedName("status")
    val status: String
) :Serializable

