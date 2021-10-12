package com.example.userlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import com.example.userlist.R
import androidx.fragment.app.add
import androidx.fragment.app.replace
import com.example.userlist.model.*
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.view.Adapter.idClickListener
import javax.inject.Inject

class MainActivity() : AppCompatActivity(), idClickListener {

    @Inject
    lateinit var retrofitService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init Main Frag
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
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

    override  fun onBackPressed():Unit {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<MainFragment>(
                R.id.fragment_container_view
            )

        }
    }
}