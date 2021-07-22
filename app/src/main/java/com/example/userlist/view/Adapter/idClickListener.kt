package com.example.userlist.view.Adapter

import android.view.View
import com.example.userlist.model.Address
import com.example.userlist.model.Company
import com.example.userlist.model.Geo
import com.example.userlist.model.UserModelItem

interface idClickListener {
    fun getIDClick(view: View, userModelItem: UserModelItem)
}