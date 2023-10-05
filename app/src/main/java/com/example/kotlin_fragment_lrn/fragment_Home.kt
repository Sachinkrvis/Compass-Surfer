package com.example.kotlin_fragment_lrn

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_fragment_lrn.adapters.adapter
import com.example.kotlin_fragment_lrn.adapters.apiInterface
import com.example.kotlin_fragment_lrn.databinding.ActivityFragmentHomeBinding
import com.example.kotlin_fragment_lrn.myData_package.myDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class fragment_Home : Fragment() {

    private lateinit var binding: ActivityFragmentHomeBinding
    val data = ArrayList<container>()
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
                    data.add(container(R.drawable.simple_4, mydata.username))
                }
                onActivatingRecyclerviewAdapter()
            }

            override fun onFailure(call: Call<List<myDataItem>?>, t: Throwable) {
                Toast.makeText(context, "Something went Wrong", Toast.LENGTH_SHORT).show()
            }
        })

    }

    // function for the adapter
    private fun onActivatingRecyclerviewAdapter() {
        val recyclerview: RecyclerView = binding.recyclerView
        val recyclerview2: RecyclerView = binding.recyclerView2
        recyclerview.layoutManager = GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false)
        recyclerview2.layoutManager=GridLayoutManager(context,1,RecyclerView.HORIZONTAL,false)
        val Adapter = adapter(data)
        recyclerview.adapter = Adapter
        recyclerview2.adapter=Adapter
    }

}