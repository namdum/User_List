/**
 * Author Eugene Brown
App: UserList
Class: MainActivity
Usage: MainActivity uses fragment manager to instantiate and replace fragment
when user chooses item.
 Also, implements interface to retrieve id for character
 **/
package com.example.userlist.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.userlist.R
import com.example.userlist.view.Adapter.idClickListener

class MainActivity() : AppCompatActivity(), idClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init Main Frag
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
               // setReorderingAllowed(true)
                add<MainFragment>(
                    R.id.fragment_container_view
                )

            }
        }
    }

    override fun getIDClick(
        view: View,  userModelItem: Int,
    ) {
        val bundle = Bundle()
        bundle.putInt("overview_data", userModelItem)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<DetailsFragment>(
                R.id.fragment_container_view,
                "overview", args = bundle
            )
        }
    }


    override  fun onBackPressed() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<MainFragment>(
                R.id.fragment_container_view
            )

        }
    }
}