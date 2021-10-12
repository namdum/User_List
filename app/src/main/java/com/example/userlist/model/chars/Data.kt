package com.example.userlist.model.chars


import com.google.gson.annotations.SerializedName
import java.io.Serializable

//class Data : ArrayList<DataModelItem>()

data class Data(
    @SerializedName("count")
    val count: String,
    @SerializedName("limit")
    val limit: String,
    @SerializedName("offset")
    val offset: String,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: String
):Serializable
data class Result(
    @SerializedName("comics")
    val comics: Comics,
    @SerializedName("description")
    val description: String,
    @SerializedName("events")
    val events: Events,
    @SerializedName("id")
    val id: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("stories")
    val stories: Stories,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("urls")
    val urls: List<Url>
) : Serializable