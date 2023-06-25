package com.example.userlist.view.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userlist.databinding.AdapterNavBinding
import com.example.userlist.databinding.AdapterUsersBinding
import com.example.userlist.model.chars.Result

class NavAdapter: RecyclerView.Adapter<NavViewHolder>() {

    //create mutable list
    private var users = mutableListOf<String>()

    private lateinit var clickHandler: idNavListener


    //dataset from init user list
    fun setUserList(users: MutableList<String>) {
        this.users = users.toMutableList()
        print(users.toString())
        notifyDataSetChanged()
    }
    fun setUserListChoice(users: List<Result>, position:Int){
        this.users = users.toMutableList()[position] as MutableList<String>
        // notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterNavBinding.inflate(
            inflater,
            parent, false
        )

        clickHandler = parent.context as idNavListener
        return NavViewHolder(binding)
    }

    //bind the data instance to the viewholder
    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
        // clickHandler.getPosition(position)

            holder.binding.alphabetView.text = this.users[position]
            holder.binding.alphabetView.setOnClickListener {
                clickHandler.getNavAlpha(this.users[position].toString())



            }

//holds cardview data
/* holder.binding.name.text = name
//holder.binding.emailText.text = desc

//holds thumbnal image
Glide.with(holder.itemView.context)
    .load(urlImg)
    .centerInside()
    .into(holder.binding.imageview)*/





/*  //listener for image click event
holder.binding.imageview.setOnClickListener {
    clickHandler.getIDClick(it, id.toInt(), desc.toString(), name, position)
}*/

}

override fun getItemCount(): Int {
return users.size
}
}

// viewholder
class NavViewHolder(var binding: AdapterNavBinding) : RecyclerView.ViewHolder(binding.root) {
}