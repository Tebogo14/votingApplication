package com.example.votingapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.votingapplication.databinding.ResultsPageBinding

class Results: AppCompatActivity() {
    private lateinit var binding: ResultsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ResultsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvYespercent.text = binding.simpleProgressBar.progress.toString() + "%"
        binding.tvNoPercent.text = binding.simpleProgressBar1.progress.toString() + "%"

        val subject = findViewById<TextView>(binding.tvSubject.id)
        subject.text = getIntent().getStringExtra("argument")
    }
}