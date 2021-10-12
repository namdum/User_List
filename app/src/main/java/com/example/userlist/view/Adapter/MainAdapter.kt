 package com.example.userlist.view.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userlist.databinding.AdapterUsersBinding
import com.example.userlist.model.chars.Result

 class MainAdapter(context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    //create mutable list
    private var users = mutableListOf<Result>()


    //dataset from init movie list
    fun setUserList(users: List<Result>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    private val clickHandler: idClickListener = context as idClickListener
    // private val idHandler: idListener = context as idListener

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
        val id: String = users[position].id

        val desc: String = users[position].description
        val name: String = users[position].name
        val thumbExt: String = users[position].thumbnail.extension
        val thumbPath: String = users[position].thumbnail.path
        val urlImg: String = "$thumbPath.$thumbExt"
        println(urlImg)
        /*val attrTxt: String = users[position].attributionText*/
        /*val copyright: String = users[position].copyright*/
        /*val etag:String = users[position].etag*/
        /*val status:String = users[position].status*/

       /* val data:Data = users[position].data
        val result: Result = users[position].data.results
        val name: String = users[position].data.results.name
        val desc: String = users[position].data.results.description
*/
        // val mod :String = users[position].modified
       // val comics: Comics = users[position].comics
        //val events: Events = users[position].events
        //val res: String = users[position].resourceURI
       // val series: Series = users[position].series
        //val stories: Stories = users[position].stories
        //val urls: List<Url> = users[position].urls









        //holds cardview data
        holder.binding.name.text = name
        holder.binding.emailText.text = desc

        //holds thumbnal image
        Glide.with(holder.itemView.context)
            .load(urlImg)
           // .placeholder(R.drawable.img_not_found)
            .centerInside()
            .into(holder.binding.imageview)


        //listener for image click event
        holder.binding.imageview.setOnClickListener {
            clickHandler.getIDClick(it, id.toInt())
            //idHandler.getID(id)
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }
}

// viewholder
class MainViewHolder(var binding: AdapterUsersBinding) : RecyclerView.ViewHolder(binding.root) {
}