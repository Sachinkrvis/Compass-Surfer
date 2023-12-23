package com.example.kotlin_fragment_lrn.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_fragment_lrn.R
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment
import com.google.android.gms.maps.model.LatLng

class StreetView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_street_view)

        val fragment=supportFragmentManager.findFragmentById(R.id.streetView) as SupportStreetViewPanoramaFragment

        fragment?.getStreetViewPanoramaAsync { streetViewpanorama->streetViewpanorama.setPosition(

            LatLng(40.690389,-74.045901)
        )
        }
    }
}