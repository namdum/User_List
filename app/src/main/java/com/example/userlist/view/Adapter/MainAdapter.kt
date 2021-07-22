package com.example.userlist.view.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.model.UserModelItem
import com.example.userlist.databinding.AdapterUsersBinding
import com.example.userlist.model.Address
import com.example.userlist.model.Company
import com.example.userlist.model.Geo
import com.example.userlist.view.DetailsFragment

class MainAdapter(context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    //create mutable list
    private var users = mutableListOf<UserModelItem>()


    //dataset from init movie list
    fun setUserList(users: List<UserModelItem>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    private val clickHandler: idClickListener = context as idClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterUsersBinding.inflate(
            inflater,
            parent, false
        )/**/

        return MainViewHolder(binding)
    }

    //bind the data instance to the viewholder
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val name: String = users[position].name
        val email: String = users[position].email
        val addr: Address = users[position].address
        val company:Company = users[position].company
        val id:Int = users[position].id
        val phone:String = users[position].phone
        val username:String = users[position].username
        val website:String = users[position].website
        val geo:Geo = users[position].address.geo





        //Overview object to send details of instance
        val userObj = UserModelItem(
            addr,
            company,
            email,
            id,
            name,
            phone,
            username,
            website
        )



        //holds cardview data
        holder.binding.name.text = name
        holder.binding.emailText.text = email
        //listener for image click event
        holder.binding.emailText.setOnClickListener {
            clickHandler.getIDClick(it, userObj)
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }
}

// viewholder
class MainViewHolder(var binding: AdapterUsersBinding) : RecyclerView.ViewHolder(binding.root) {
}