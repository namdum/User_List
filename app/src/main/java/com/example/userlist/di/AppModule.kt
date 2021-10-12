package com.example.userlist.di

import com.example.userlist.model.retrofitAPI.RetrofitService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

  val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
  }

  @Provides
  @Singleton
  fun provideRetrofit(): RetrofitService {
    return Retrofit.Builder()
      .baseUrl("https://gateway.marvel.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient())
      .build()
      .create(RetrofitService::class.java)
  }

  @Provides
  @Singleton
  fun okHttpClient(): OkHttpClient {
    val client: OkHttpClient.Builder = OkHttpClient.Builder()
    client.addInterceptor(interceptor)
    return client.build()
  }

}