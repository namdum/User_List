package com.example.userlist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userlist.model.Repository
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.view.Adapter.MainAdapter
import com.example.userlist.viewmodel.UserViewModel
import com.example.userlist.viewmodel.ViewModelFactory
import com.example.userlist.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    // View Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val TAG = "MainFragment"




     @Inject
    lateinit var retrofitService:RetrofitService

    lateinit var viewModelFactory: ViewModelFactory

    private var adapter: MainAdapter? = null

    // Create a viewModel
    private lateinit var viewModel: UserViewModel


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
        )
            .get(UserViewModel::class.java)



        //init adapter for recyclerview
        adapter = MainAdapter()

        val view = binding.root

        //add adapter to recyclerview
        binding.mainRV.adapter = adapter!!

        return view
    }

    // init service
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllUsers()

        fragmentTextUpdateObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {

        viewModel.charList.observe(viewLifecycleOwner,{
            adapter!!.setUserList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner,{
            println("error: " + it)
        })

    }
}