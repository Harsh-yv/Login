package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.LoginBinding
import com.example.myapplication.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Main : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)}
        binding.button2.setOnClickListener{
            val intent=Intent(this,Login::class.java)
            startActivity(intent)}
    }
}