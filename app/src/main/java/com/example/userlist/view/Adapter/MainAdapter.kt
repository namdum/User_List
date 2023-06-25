/**
 * Author Eugene Brown
App: UserList
Class: MainAdapter
Usage: the main adapter provides data for recyclerview
 using livedata and view binding for viewholder
 **/
package com.example.userlist.view.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.ALLOW
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.example.userlist.databinding.AdapterUsersBinding
import com.example.userlist.model.chars.Result

 class MainAdapter() : RecyclerView.Adapter<MainViewHolder>() {

    //create mutable list
    private var users = mutableListOf<Result>()

    private lateinit var clickHandler: idClickListener


    //dataset from init user list
    fun setUserList(users: List<Result>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }
     fun setUserListChoice(users: List<Result>, position:Int){
         this.users = users.toMutableList()[position] as MutableList<Result>
        // notifyDataSetChanged()
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterUsersBinding.inflate(
            inflater,
            parent, false
        )

        clickHandler = parent.context as idClickListener
        return MainViewHolder(binding)
    }

    //bind the data instance to the viewholder
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       // clickHandler.getPosition(position)
        val id: String = users[position].id
        val desc: String = users[position].description
        val name: String = users[position].name
        val thumbExt: String = users[position].thumbnail.extension
        val thumbPath: String = users[position].thumbnail.path
        val urlImg = "$thumbPath.$thumbExt"
        print(thumbPath.toString())
        Log.d("BINDVH", "onBindViewHolder: $thumbPath")
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
        //holder.binding.emailText.text = desc

        //holds thumbnal image
        Glide.with(holder.itemView.context)
            .load(urlImg)
            .centerInside()
            .into(holder.binding.imageview)





        //listener for image click event
        holder.binding.imageview.setOnClickListener {
            clickHandler.getIDClick(it, id.toInt(), desc.toString(), name, position)
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }
}

// viewholder
class MainViewHolder(var binding: AdapterUsersBinding) : RecyclerView.ViewHolder(binding.root) {
}