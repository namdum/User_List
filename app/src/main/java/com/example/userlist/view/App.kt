/**
 * Author Eugene Brown
App: UserList
Class: App
Usage: Entry point for application UseList displays Marvel Characters w/ definition
and image of comics.
this class builds Dagger2 component for dependency Injection
 **/

package com.example.userlist.view

import android.app.Application
import com.example.userlist.di.AppModule
import com.example.userlist.di.ComicsComponent
import com.example.userlist.di.DaggerComicsComponent


class App :Application() {
  override fun onCreate() {
    super.onCreate()

    component = DaggerComicsComponent
      .builder()
      .appModule(AppModule())
      .build()
  }


}
lateinit var component: ComicsComponent
