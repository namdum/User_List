package com.example.userlist.view.Adapter

import android.view.View
import com.example.userlist.model.*
import com.example.userlist.view.component
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject
@Module
interface idClickListener {

    fun getIDClick(view: View, userModelItem: Int)
    //var getId:String
}