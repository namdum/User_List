package com.example.userlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.userlist.R
import com.example.userlist.databinding.FragmentDetailsBinding
import com.example.userlist.model.Repository
import com.example.userlist.model.UserModelItem

class DetailsFragment : Fragment() {

    // View Binding
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val TAG = "OverViewFragment"

    //object from main list cardview instance
    private lateinit var detailsArrayList: UserModelItem

    //repository class
    private val repository: Repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //from bundle
        detailsArrayList = requireArguments()
            .getSerializable("overview_data")!! as UserModelItem

        //binding view
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //overview descrption text
        binding.IDTxt.text = detailsArrayList.id.toString()
        binding.addrTxt.text = getString(R.string.street, detailsArrayList.address.street)
        binding.companyTxt.text = getString(R.string.company, detailsArrayList.company.name)
        binding.catchphraseTxt.text =
            getString(R.string.catchphrase, detailsArrayList.company.catchPhrase)
        binding.bsTxt.text = getString(R.string.bs, detailsArrayList.company.bs)
        binding.cityTxt.text = getString(R.string.city, detailsArrayList.address.city)
        binding.userTxt.text = getString(R.string.username, detailsArrayList.username)
        binding.suiteTxt.text = getString(R.string.suite, detailsArrayList.address.suite)
        binding.zipTxt.text = getString(R.string.zip, detailsArrayList.address.zipcode)
        binding.webTxt.text = getString(R.string.web, detailsArrayList.website)
        binding.phoneTxt.text = getString(R.string.phone, detailsArrayList.phone)
        binding.geoTxt.text = getString(
            R.string.geo, detailsArrayList.address.geo.lat + " " +
                    detailsArrayList.address.geo.lng
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}