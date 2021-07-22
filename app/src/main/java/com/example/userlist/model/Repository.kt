package com.example.userlist.model

import com.example.userlist.model.retrofitAPI.RetrofitService

class Repository constructor(
    private val retrofitService: RetrofitService? = null,

) {

    fun getAllUsers() = retrofitService!!.getAllUsers()


}