package com.example.kotlin_fragment_lrn.view.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class signUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

        binding.logintext.setOnClickListener {
            val intent=Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener {
            val fullname=binding.nameEt.text.toString()
            val email=binding.emailEt.text.toString()
            val password=binding.passwordEt.text.toString()
            val cnfPassword=binding.cnfpasswordEt.text.toString()
            if(fullname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && cnfPassword.isNotEmpty()){
                if(password==cnfPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent=Intent(this, LogIn::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Passsword Should be same", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please Fill the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }
}