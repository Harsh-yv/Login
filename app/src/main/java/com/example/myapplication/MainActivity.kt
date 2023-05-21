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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: RegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()
        binding.textView2.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener{
            val email=binding.email.text.toString()
            val pass=binding.password.text.toString()
            val confirmpass=binding.ConfirmPassword.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty())
            {
                if(pass==confirmpass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent=Intent(this,Login::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    Toast.makeText(this,"Password is not matchiong",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Empty Fields are not allowed",Toast.LENGTH_SHORT).show()
            }
        }
}
}


