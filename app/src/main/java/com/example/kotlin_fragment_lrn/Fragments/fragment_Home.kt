package com.example.kotlin_fragment_lrn.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.adapterContainer.container
import com.example.kotlin_fragment_lrn.adapterContainer.container_newFeed
import com.example.kotlin_fragment_lrn.adapters.adapter_newFeed
import com.example.kotlin_fragment_lrn.adapters.adapter_recents
import com.example.kotlin_fragment_lrn.adapters.apiInterface
import com.example.kotlin_fragment_lrn.databinding.ActivityFragmentHomeBinding
import com.example.kotlin_fragment_lrn.maps.MapsActivity
import com.example.kotlin_fragment_lrn.myData_package.myDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class fragment_Home : Fragment() {

    private lateinit var binding: ActivityFragmentHomeBinding
    val recent_data = ArrayList<container>()
    val newFeed_data=ArrayList<container_newFeed>()
    val baseUrl = "https://jsonplaceholder.typicode.com/"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ActivityFragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onDataLoadFromApi()

    }

    private fun onClicked() {
        val intent=Intent(activity,MapsActivity::class.java)
        startActivity(intent)
    }

    // function for api Call using retrofit
    private fun onDataLoadFromApi() {
        val retrofitbuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(apiInterface::class.java)

        val retrofitdata = retrofitbuilder.getData()
        retrofitdata.enqueue(object : Callback<List<myDataItem>?> {
            override fun onResponse(
                call: Call<List<myDataItem>?>,
                response: Response<List<myDataItem>?>,
            ) {
                val responsedata = response.body()!!

                for (mydata in responsedata) {
                    recent_data.add(container(R.drawable.simple_4, mydata.username))
                    newFeed_data.add(container_newFeed(mydata.name))
                }
                onActivatingRecyclerviewAdapter()
                onActivatingnewFeedRecyclerviewAdapter()
            }

            override fun onFailure(call: Call<List<myDataItem>?>, t: Throwable) {
                Toast.makeText(context, "Something went Wrong", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun onActivatingnewFeedRecyclerviewAdapter() {
        val recyclerView:RecyclerView=binding.newFeedsRecyclerView
        recyclerView.layoutManager=LinearLayoutManager(context)
        val Adapter= adapter_newFeed(newFeed_data)
        recyclerView.adapter=Adapter

    }

    // function for the adapter
    private fun onActivatingRecyclerviewAdapter() {
        val recyclerview: RecyclerView = binding.recyclerView
        recyclerview.layoutManager = GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false)
        val Adapter = adapter_recents(recent_data)
        recyclerview.adapter = Adapter
    }

}