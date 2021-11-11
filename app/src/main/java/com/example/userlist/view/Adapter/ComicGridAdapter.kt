/**
 * Author Eugene Brown
App: UserList
Class: ComicGridAdapter
Usage: Adapter for DetailsFragment. Posts grid of images 2x2 from API
 **/

package com.example.userlist.view.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.userlist.R
import com.example.userlist.databinding.ViewGridBinding
import com.example.userlist.model.comics.Results

class ComicGridAdapter( private val list: List<Results>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ViewGridBinding
        val inflater = parent?.context?.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewGridBinding.inflate(inflater, parent, false)
        val row = binding.root
        val imgUrl:String = list[position].thumbnail.path + "." +
                list[position].thumbnail.extension
        Glide.with(row)
            .load(imgUrl)
            .placeholder(R.drawable.img_not_found)
            .centerInside()
            .into(binding.imgComicView)
        return row
    }

    override fun getItem(position: Int): Results = list[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = list.size
}