package com.example.votingapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.votingapplication.databinding.LoginPageBinding
import com.example.votingapplication.databinding.ProgressViewBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding
    private lateinit var progressbinding: ProgressViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        progressbinding = ProgressViewBinding.inflate(layoutInflater)

        val frameLayout = findViewById<View>(progressbinding.progressView.id);


        val button = findViewById<Button>(binding.btnLogin.id);

        button.setOnClickListener {

            frameLayout.isVisible = true;
            Toast.makeText(this, "Tebogo langa", Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, Landing::class.java)

            frameLayout.isVisible = false;
            startActivity(intent)
        }

    }


}