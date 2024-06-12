package com.example.newtry

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newtry.models.ProductListResponseItem
import com.squareup.picasso.Picasso

class AdapterItemList( private val arrayList: ArrayList<ProductListResponseItem>) : RecyclerView.Adapter<AdapterItemList.hello>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterItemList.hello {
        Log.d("AdapterItemList","oncreateViewHolder")
    var CreateHolder = LayoutInflater.from(parent.context)
        .inflate(R.layout.itemlist,parent,false)

        return hello(CreateHolder)
    }


    override fun onBindViewHolder(holder: hello, position: Int) {
        Log.d("AdapterItemList","onBindViewHolder")
       holder.Txtview.text = arrayList[position].category
        Picasso.get().load(arrayList[position].image).into(holder.Imgview)
    }


    override fun getItemCount(): Int {
        Log.d("AdapterItemList","GetItemCount")
        return arrayList.size
    }
    class hello( Holder : View) : RecyclerView.ViewHolder(Holder){
        var Imgview = Holder.findViewById<AppCompatImageView>(R.id.Imgview)
        var Txtview = Holder.findViewById<AppCompatTextView>(R.id.Txtview)
    }
}