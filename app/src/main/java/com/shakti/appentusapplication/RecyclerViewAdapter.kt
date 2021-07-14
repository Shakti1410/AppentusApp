package com.shakti.appentusapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.shakti.appentusapplication.model.ResponseImageItem


class RecyclerViewAdapter:PagingDataAdapter<ResponseImageItem,RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack) {



    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.image_item)
         fun bind(data:ResponseImageItem){

             Glide.with(image).load(data.download_url).into(image)

         }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return  MyViewHolder(view)
    }

    object DiffUtilCallBack:DiffUtil.ItemCallback<ResponseImageItem>(){
        override fun areItemsTheSame(
            oldItem: ResponseImageItem,
            newItem: ResponseImageItem
        ): Boolean {
            return oldItem.download_url == newItem.download_url
        }

        override fun areContentsTheSame(
            oldItem: ResponseImageItem,
            newItem: ResponseImageItem
        ): Boolean {
            return oldItem== newItem
        }

    }
}