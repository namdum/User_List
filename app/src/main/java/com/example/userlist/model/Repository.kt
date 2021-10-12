package com.example.userlist.model

import com.example.userlist.BuildConfig
import com.example.userlist.model.retrofitAPI.RetrofitService
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val retrofitService: RetrofitService) {

  private val apikey: String = BuildConfig.API_KEY
  private val hash: String = BuildConfig.HASH
  private var ts: String = Timestamp(System.currentTimeMillis()).toString()

  suspend fun getAllChar() = retrofitService.getAllChars(
    ts, apikey, md5(ts + hash + apikey), "name"
  )

  suspend fun getAllComics(id: Int) = retrofitService.getAllComics(
    id, ts, apikey, md5(ts + hash + apikey), 10
  )

  //helper function for md5 hash move to folder
  fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
  }
}