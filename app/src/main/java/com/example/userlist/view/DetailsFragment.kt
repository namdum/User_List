/**
 * Author Eugene Brown
App: UserList
Class: DetailsFragment
Usage: presents the gridview layout of images from character
uses ViewModel and observer pattern to send data to adapter
 uses view binding
 **/
package com.example.userlist.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.userlist.databinding.FragmentDetailsBinding
import com.example.userlist.model.Repository
import com.example.userlist.model.comics.Results
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.view.Adapter.ComicGridAdapter
import com.example.userlist.view.Adapter.idClickListener
import com.example.userlist.viewmodel.UserViewModel
import com.example.userlist.viewmodel.ViewModelFactory
import javax.inject.Inject

class DetailsFragment : Fragment(){

    // View Binding
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val TAG = "OverViewFragment"


    // Create a viewModel
    private lateinit var viewModel: UserViewModel



    @Inject
    lateinit var retrofitService: RetrofitService

    @Inject
    lateinit var factory: ViewModelFactory
    //create mutable list
    //private  var users = mutableListOf<Results>()


    private  var idChar:Int = 0
    private var idDesc:String? ="no details"
    private var idName:String? = "no name"
    private var positionRV:Int =  0
    private lateinit var clickHandler: idClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.injectDetails(this)
        //from bundle*/
        //object from main list cardview instance
        val detailsArrayList = requireArguments().getInt("overview_data")
        this.idChar = detailsArrayList
        // adding desc
        val descUserItem = requireArguments().getString("user_desc")
        this.idDesc = descUserItem

        val descUserName = requireArguments().getString("user_name")
        this.idName = descUserName

        positionRV  = requireArguments().getInt("position")

        clickHandler = context as idClickListener

        //binding view
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.emailText2.text = descUserItem
        binding.IDTxt.text = descUserName
        binding.IDTxt.setOnClickListener {
            clickHandler.getPosition(positionRV)

        }
        factory = ViewModelFactory(Repository(retrofitService))

//use view model provider factory for param
        viewModel = ViewModelProvider(
            this,
            factory
        )
            .get(UserViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllComics(this.idChar)
        fragmentTextUpdateObserver()
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {

        viewModel.comicList.observe(viewLifecycleOwner) { comicList ->
//add desc here
            binding.gridView.adapter = ComicGridAdapter(comicList)

        }
        viewModel.errorMessage.observe(viewLifecycleOwner,{
            println("error: " + it)
        })

    }


}