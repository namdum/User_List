package com.example.userlist.model.comics


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    /*@SerializedName("characters")
    val characters: Character,
    @SerializedName("collectedIssues")
    val collectedIssues: List<CollectedIssue>,*/
    @SerializedName("collections")
    val collections: List<Collection>,
    @SerializedName("creators")
    val creators: Creators,
    @SerializedName("dates")
    val dates: List<Date>,
    @SerializedName("description")
    var description: String?,
    @SerializedName("diamondCode")
    val diamondCode: String,
    @SerializedName("digitalId")
    val digitalId: String,
    @SerializedName("ean")
    val ean: String,
    @SerializedName("events")
    val events: Events,
    @SerializedName("format")
    val format: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("issn")
    val issn: String,
    @SerializedName("issueNumber")
    val issueNumber: String,
   // @SerializedName("modified")
   // val modified: String,
    //@SerializedName("pageCount")
    //val pageCount: String,
    @SerializedName("prices")
    val prices: List<Price>,
    @SerializedName("resourceURI")
    val resourceURI: String,
    /*@SerializedName("series")
    val series: Series,
    @SerializedName("stories")
    val stories: Stories,
    @SerializedName("textObjects")
    val textObjects: List<TextObject>,*/
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String,
   /* @SerializedName("upc")
    val upc: String,
    @SerializedName("urls")
    val urls: List<Url>,
    @SerializedName("variantDescription")
    val variantDescription: String,
    @SerializedName("variants")
    val variants: List<Variant>*/
):Serializable