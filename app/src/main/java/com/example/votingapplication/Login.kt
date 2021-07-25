package com.example.votingapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.votingapplication.databinding.LoginPageBinding


class Login : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val button = findViewById<Button>(binding.btnLogin.id);

        button.setOnClickListener {
            print("Tebogo Langa");
            val intent = Intent(applicationContext, Landing::class.java)
            startActivity(intent)
        }
    }

}





