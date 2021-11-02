package com.example.userlist.model.retrofitAPI

import com.example.userlist.model.chars.Characters
import com.example.userlist.model.comics.Comic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    @GET("v1/public/characters")
    suspend fun getAllChars(@Query("ts") ts: String,
                    @Query("apikey") apikey: String,
                    @Query("hash") hash: String,
                    @Query("limit") limit:Int,
                    @Query("orderBy") orderBy: String,
                    @Query("nameStartsWith") nameStartsWith: String
): Response <Characters>

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getAllComics(@Path("characterId") characterId: Int,
                    @Query("ts") ts: String,
                    @Query("apikey") apikey: String,
                    @Query("hash") hash: String,
                    @Query("limit") limit:Int,
                    //@Query("orderBy") orderBy: String
    ): Response <Comic>

}