package com.example.votingapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.votingapplication.databinding.VotePageBinding

class Vote:AppCompatActivity() {
    private lateinit var binding: VotePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = VotePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subject = findViewById<TextView>(binding.tvSubject.id)
        subject.text = getIntent().getStringExtra("argument")

        binding.btnNo.setOnClickListener{
            val intent = Intent(applicationContext, Results::class.java)
            startActivity(intent)
        }
        binding.btnYes.setOnClickListener{
            val intent = Intent(applicationContext, Results::class.java)
            startActivity(intent)
        }
    }
}