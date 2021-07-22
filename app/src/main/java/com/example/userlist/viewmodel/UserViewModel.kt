package com.example.userlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userlist.model.Repository
import com.example.userlist.model.UserModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor(private var repository: Repository) : ViewModel() {

    // Create MutableLiveData which MainFragment can subscribe to
    // When this data changes, it triggers the UI to do an update

    //from retrofit
    val userList = MutableLiveData<List<UserModelItem>>()

    //error for logging
    val errorMessage = MutableLiveData<String>()


    //response from init call
    fun getAllUsers() {
        val response = repository.getAllUsers()
        response.enqueue(object : Callback <List<UserModelItem>> {

            override fun onResponse(call: Call <List<UserModelItem>>, response: Response <List<UserModelItem>>) {
                userList.postValue(response.body())

            }

            override fun onFailure(call: Call <List<UserModelItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}