package com.example.kotlin_fragment_lrn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.kotlin_fragment_lrn.view.Fragments.fragment_Department
import com.example.kotlin_fragment_lrn.view.Fragments.fragment_Home
import com.example.kotlin_fragment_lrn.view.Fragments.fragment_peoples
import com.example.kotlin_fragment_lrn.view.Fragments.fragment_profile
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.setOnItemSelectedListener(this)

    }

    // menu function
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toobar, menu)
        return true
    }


    // adding the functionality to the tool bar item selected
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.toolbar_refresh -> {
            Toast.makeText(this, "This is refresh when it is clicked", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.toolbar_reset -> {
            Toast.makeText(this, "This is reset when it is clicked", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.toolbar_setting -> {
            Toast.makeText(this, "This is setting when it is clicked", Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    //  running the navigation bar(navigation fragment swapping)
    fun onClickedHome(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.fragmement_content, fragment_Home())
        }
        return true
    }

    fun onClickedPeoples(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.fragmement_content, fragment_peoples())
        }
        return true
    }

    fun onClickedDepartment(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.fragmement_content, fragment_Department())
        }
        return true
    }

//    fun onClickedProfile(): Boolean {
//        supportFragmentManager.commit {
//            replace(R.id.fragmement_content, fragment_profile())
//        }
//        return true
//    }

    // this will affect the code on the github
    // on item is selected on the Navigation bar(calling when expression)
    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_home -> onClickedHome()
        R.id.nav_peoples -> onClickedPeoples()
        R.id.nav_department -> onClickedDepartment()
//        R.id.nav_profile -> onClickedProfile()
        else -> false
    }
}