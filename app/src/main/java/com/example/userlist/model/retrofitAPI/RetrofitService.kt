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
                    //@Query("limit") limit:Int,
                    @Query("orderBy") orderBy: String
): Response <Characters>

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getAllComics(@Path("characterId") characterId: Int,
                    @Query("ts") ts: String,
                    @Query("apikey") apikey: String,
                    @Query("hash") hash: String,
                    @Query("limit") limit:Int,
                    //@Query("orderBy") orderBy: String
    ): Response <Comic>

   /* companion object {
        var retrofitService: RetrofitService? = null

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://gateway.marvel.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }*/
}