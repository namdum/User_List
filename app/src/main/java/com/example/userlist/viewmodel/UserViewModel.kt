package com.example.userlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userlist.model.Repository
import com.example.userlist.model.chars.Result
import com.example.userlist.model.comics.Results
import kotlinx.coroutines.*
import javax.inject.Inject

class UserViewModel @Inject constructor( var repository: Repository) : ViewModel() {

  // Create MutableLiveData which MainFragment can subscribe to
  // When this data changes, it triggers the UI to do an update

  //from retrofit
  private val _charData = MutableLiveData<List<Result>>()
  val charList: LiveData<List<Result>> get() = _charData

  val _comicData = MutableLiveData<List<Results>>()
  val comicList: LiveData<List<Results>> get() = _comicData

  //error for logging
  val errorMessage = MutableLiveData<String>()

  var job: Job? = null

  val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    onError("Exception handled: ${throwable.localizedMessage}")
  }


  //response from init call
  fun getAllUsers() {

    viewModelScope.launch(exceptionHandler) {

      val response = repository.getAllChar()

      if (response.isSuccessful) {
        _charData.value  = response.body()!!.data.results

      } else {
        //  }
        onError("Error: ${response.message()} ")
      }
    }
  }

  //response from id call
  fun getAllComics(id: Int) {

    viewModelScope.launch {

      val response = repository.getAllComics(id)

      withContext(Dispatchers.Main) {

        if (response.isSuccessful) {
          _comicData.value = response.body()!!.data.results
        } else {
          //  }
          onError("Error: ${response.message()} ")
        }
      }
    }
  }

  private fun onError(message: String) {
    errorMessage.value = message
  }
}