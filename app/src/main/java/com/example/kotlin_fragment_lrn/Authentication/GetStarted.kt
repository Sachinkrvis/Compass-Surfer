package com.example.kotlin_fragment_lrn.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_fragment_lrn.MainActivity
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.databinding.ActivityGetStartedBinding
import com.google.firebase.auth.FirebaseAuth

class GetStarted : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

        binding.getStarted.setOnClickListener {
            val intent=Intent(this,LogIn::class.java)
            startActivity(intent)
        }

    }
    override fun onStart() {
        super.onStart()

        // Check if the user is already logged in
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // User is already logged in, redirect to the main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}