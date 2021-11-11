/**
 * Author Eugene Brown
App: UserList
Class: idClickLisyener
Usage: Listener for ID of character to pass variable fom MainFragment to details Fragment
 **/
package com.example.userlist.view.Adapter

import android.view.View
import dagger.Module

@Module
interface idClickListener {

    fun getIDClick(view: View, userModelItem: Int)
}