package com.example.userlist.view

import android.app.Application
import com.example.userlist.di.ComicsComponent
import com.example.userlist.di.DaggerComicsComponent

class App :Application() {
  override fun onCreate() {
    super.onCreate()

    component = DaggerComicsComponent
      .builder()
      .build()
  }
}
lateinit var component: ComicsComponent