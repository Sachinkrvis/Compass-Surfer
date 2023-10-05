package com.example.kotlin_fragment_lrn.adapters

import com.example.kotlin_fragment_lrn.myData_package.myDataItem
import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {
    @GET(/* value = */ "users")
    fun getData(): Call<List<myDataItem>>
}