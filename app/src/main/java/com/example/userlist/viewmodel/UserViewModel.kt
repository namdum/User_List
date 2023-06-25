/**
 * Author Eugene Brown
App: UserList
Class: UserViewModel
Usage: the view Model for MVVM design structure. The repository object is assigned to
livedata in coroutine to send API data to Observer.
 **/
package com.example.userlist.viewmodel

import android.os.Parcelable
import androidx.lifecycle.*
import com.example.userlist.model.Repository
import com.example.userlist.model.chars.Result
import com.example.userlist.model.comics.Results
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import retrofit2.Response
import javax.annotation.Resource
import javax.inject.Inject

class UserViewModel @Inject constructor( var repository: Repository) : ViewModel() {


  // Create MutableLiveData which MainFragment can subscribe to
  // When this data changes, it triggers the UI to do an update

  //from retrofit
  private val _charData = MutableLiveData<List<Result>>()
  val charList: LiveData<List<Result>> get() = _charData

  private val _comicData = MutableLiveData<List<Results>>()
  val comicList: LiveData<List<Results>> get() = _comicData

  var navListLive: MutableLiveData<MutableList<String>> = MutableLiveData(mutableListOf())

  //error for logging
  val errorMessage = MutableLiveData<String>()

  //lateinit var response:Response<Characters>

  private lateinit var job: Job
  //private lateinit var state: Parcelable
  //fun saveRecyclerViewState(parcelable: Parcelable) { state = parcelable }
  //fun restoreRecyclerViewState() : Parcelable = state
  //fun stateInitialized() : Boolean = ::state.isInitialized

  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    onError("Exception handled: ${throwable.localizedMessage}")
  }
/*companion object{
  private val CHAR_ID = "char_id"

}
  private val savedStateHandle = state


  fun saveCharPosition(charId: Int){
    savedStateHandle.set(CHAR_ID, charId)

  }
*/

  //private var _navListLive : MutableLiveData<Array<String>> = MutableLiveData()
 /// var navListLive: LiveData<Array<String>>  = _navListLive

fun addNavToList(picture: String) {
  navListLive.value?.add(picture)
  navListLive.value = navListLive.value

}


  //response from init call
   fun getAllUsers()  {

    job = viewModelScope.launch(exceptionHandler) {

      val response = repository.getAllChar()

      if (response.isSuccessful) {
        _charData.value  = response.body()!!.data.results

      } else {
        //  }
        onError("Error: ${response.message()} ")
      }
    }
  }
  fun getAllUsers(name:String)  {

    job = viewModelScope.launch(exceptionHandler) {

      val response = repository.getAllChar(name)

      if (response.isSuccessful) {
        _charData.value  = response.body()!!.data.results

      } else {
        //  }
        onError("Error: ${response.message()} ")
      }
    }
  }
  //response from id  details call
  fun getAllComics(id: Int) {

    job = viewModelScope.launch {

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
  override fun onCleared() {
    super.onCleared()
    job.cancel()
  }
}