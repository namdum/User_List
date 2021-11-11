/**
 * Author Eugene Brown
App: UserList
Class: Repository
Usage: MVVM pattern repository handle data operations.
They provide a clean API so that the rest of the app can retrieve this data easily
 **/
package com.example.userlist.model

import com.example.userlist.BuildConfig
import com.example.userlist.model.retrofitAPI.RetrofitService
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class Repository @Inject constructor(private val retrofitService: RetrofitService) {

  private val apikey: String = BuildConfig.API_KEY
  private val hash: String = BuildConfig.HASH
  private var ts: String = Timestamp(System.currentTimeMillis()).toString()

  open suspend fun getAllChar() = retrofitService.getAllChars(
    ts, apikey, md5(ts + hash + apikey), 100,"name","a"
  )

  open suspend fun getAllComics(id: Int) = retrofitService.getAllComics(
    id, ts, apikey, md5(ts + hash + apikey), 10
  )

  //helper function for md5 hash move to folder
  private fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
  }
}