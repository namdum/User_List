package com.example.userlist.di

import com.example.userlist.model.Repository
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.view.DetailsFragment
import com.example.userlist.view.MainActivity
import com.example.userlist.view.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ComicsComponent {
   fun inject(fragment: MainFragment)
   fun injectDetails(fragment: DetailsFragment)
}