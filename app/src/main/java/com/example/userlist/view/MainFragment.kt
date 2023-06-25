/**
 * Author Eugene Brown
App: UserList
Class: MainFragment
Usage: Fragment thats holds recyclerview via view binding
uses ViewModel and observer pattern to send data to adapter
uses view binding
 **/
package com.example.userlist.view

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.databinding.FragmentMainBinding
import com.example.userlist.model.Repository
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.view.Adapter.MainAdapter
import com.example.userlist.view.Adapter.NavAdapter
import com.example.userlist.viewmodel.UserViewModel
import com.example.userlist.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment() {

    // View Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val TAG = "MainFragment"

    @Inject
    lateinit var retrofitService: RetrofitService

    private lateinit var viewModelFactory: ViewModelFactory

    private var adapter: MainAdapter? = null
    private var navAdapter: NavAdapter? = null

    // Create a viewModel
    private lateinit var viewModel: UserViewModel
    private var recyclerViewState: Parcelable? = null
    private var posInt: Int = -1
    private lateinit var posNameNav: String

    private val navArray = arrayOf(
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
        "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        //bind view
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModelFactory = ViewModelFactory(Repository(retrofitService))

        //use view model provider factory for param
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(UserViewModel::class.java)

        posNameNav = requireArguments().getString("name").toString()
        posInt = requireArguments().getInt("position")

        val view = binding.root

        navAdapter = NavAdapter()
        navAdapter!!.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding.navRV.adapter = navAdapter!!


        //init adapter for main recyclerview
        adapter = MainAdapter()
        adapter!!.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding.mainRV.adapter = adapter!!


        return view
    }

    // init service
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTextUpdateObserver()

        for (i in navArray) {
            viewModel.addNavToList(i)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {
        //init recyclerview for main RV
        if (posNameNav == "null") {
            viewModel.getAllUsers()
        }

        viewModel.navListLive.observe(viewLifecycleOwner) {
            navAdapter!!.setUserList(it)

            viewModel.getAllUsers(posNameNav)

            binding.navRV.scrollToPosition(posInt)

        }

        viewModel.charList.observe(viewLifecycleOwner) { it ->

            adapter!!.setUserList(it)
            //update position of recyclerview works in observer pattern for ui logic
            binding.mainRV.scrollToPosition(posInt)
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            println("error: " + it)
        }
    }
}