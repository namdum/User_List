/*****************************************************
 *      ViewModelFactory
 *      Eugene Brown
 *      - ViewModelFactory helper class
 *      - If you add argument in constructor you have
 *      to create your own implementation of
 *      ViewModelProvider.Factory to create your ViewModel instance.
 *****************************************************/
package com.example.userlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userlist.model.Repository
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val repository: Repository) :
  ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
      UserViewModel(this.repository) as T
    } else {
      throw IllegalArgumentException("ViewModel Not Found")
    }
  }
}