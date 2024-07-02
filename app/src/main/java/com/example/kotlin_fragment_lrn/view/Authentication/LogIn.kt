package com.example.kotlin_fragment_lrn.view.Authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_fragment_lrn.view.MainActivity
import com.example.kotlin_fragment_lrn.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

       binding.newUser.setOnClickListener {
           val intent=Intent(this, signUp::class.java)
           startActivity(intent)
       }


       binding.loginBtn.setOnClickListener {
           val username=binding.usernameEt.text.toString()
           val password=binding.passwordEt.text.toString()
           if(username.isNotEmpty() && password.isNotEmpty()){
               firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener {
                   if(it.isSuccessful){
                       val intent=Intent(this, MainActivity::class.java)
                       startActivity(intent)
                   }else{
                       Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_SHORT).show()
                   }
               }
           }else{
               Toast.makeText(this, "Please Enter the Username and Password", Toast.LENGTH_SHORT).show()
           }
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