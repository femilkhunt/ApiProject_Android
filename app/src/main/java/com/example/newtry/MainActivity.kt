package com.example.newtry

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newtry.models.ProductListResponse
import com.example.newtry.models.ProductListResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var productListAdapter: AdapterItemList? = null
    var arrayList : ArrayList<ProductListResponseItem> = arrayListOf()
    lateinit var RvProductList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RvProductList = findViewById(R.id.RvItemList)
        initAdapter()
        GetData()

    }

    fun initAdapter() {
        productListAdapter = AdapterItemList(arrayList)
        RvProductList.layoutManager = LinearLayoutManager(this)
        RvProductList.adapter = productListAdapter
    }

    fun GetData() {

        RetroFitClient.instance.GetProduct().enqueue(object : Callback<ProductListResponse> {

            override fun onResponse(
                call: Call<ProductListResponse>,
                response: Response<ProductListResponse>
            ) {
                if (response.isSuccessful){
                    //
                    response.body()?.let { arrayList.addAll(it) }
                    productListAdapter?.notifyDataSetChanged()
                }
                Log.d("Sucess", "Sucess")
            }

            override fun onFailure(call: Call<ProductListResponse>, t: Throwable) {
                Log.d("fail", "fail")
            }

        })
    }
}