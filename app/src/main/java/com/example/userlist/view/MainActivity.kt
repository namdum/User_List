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
import com.example.userlist.databinding.ActivityMainBinding
import com.example.userlist.view.Adapter.idClickListener
import com.example.userlist.view.Adapter.idNavListener


class MainActivity : AppCompatActivity(), idClickListener,idNavListener{

    // View Binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val TAG = "MainActivity"

    private val sFragManage = supportFragmentManager
    private val fragTest = sFragManage.findFragmentById(R.id.fragment_container_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //init Main Frag
        if (savedInstanceState == null) {
            var bundle = Bundle()
            bundle.putInt("init", 0)


            sFragManage.commit {
               setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view,"container2" ,args=bundle)
                addToBackStack("container2")
                println( "nnnnn "+ sFragManage.isStateSaved.toString())

            }
        }
    }

    override fun getIDClick(
        view: View,  userModelItem: Int, userDescItem: String, name:String, position: Int
    ) {
        val bundle = Bundle()
        bundle.putInt("overview_data", userModelItem)
        bundle.putString("user_desc", userDescItem)
        bundle.putString("user_name", name)
        bundle.putInt("position", position)

        sFragManage.commit {
            setReorderingAllowed(true)
            replace<DetailsFragment>(
                R.id.fragment_container_view,
                "overview", args = bundle
            )
            addToBackStack("overview")

        }

    }

    override fun getPosition(position: Int) {
    println("position $position")
    val bundle = Bundle()
    bundle.putInt("position", position)
        sFragManage.commit {
            setReorderingAllowed(true)
            remove(MainFragment())
            remove(DetailsFragment())
            replace<MainFragment>(R.id.fragment_container_view, "container" ,args = bundle)
            addToBackStack("container")

        }

    }
    override fun getNavAlpha(name: String) {
        val bundle = Bundle()

            bundle.putString("name", name)


        sFragManage.commit {
            setReorderingAllowed(true)
            remove(MainFragment())
            remove(DetailsFragment())
            replace<MainFragment>(R.id.fragment_container_view, "container3" ,args = bundle)
            addToBackStack("container3")

        }    }
    @Deprecated("Deprecated in Java")
    override  fun onBackPressed() {
        sFragManage.commit {
            setReorderingAllowed(true)
            replace<MainFragment>(
                R.id.fragment_container_view
            )

        }
    }
}