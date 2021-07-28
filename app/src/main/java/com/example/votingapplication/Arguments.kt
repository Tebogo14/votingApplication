package com.example.votingapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.votingapplication.databinding.ArgumentsBinding
import com.example.votingapplication.fragment.Argment_Fragment
import com.example.votingapplication.fragment.Landing_fragment
import com.example.votingapplication.models.SubjectArgument

class Arguments : AppCompatActivity() {

    private lateinit var binding: ArgumentsBinding

    var arrayList:  java.util.ArrayList<String> = ArrayList()
    var adapter: Argment_Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ArgumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subject = findViewById<TextView>(binding.tvSubject.id)

        subject.text = getIntent().getStringExtra("subject")

        arrayList = getIntent().getStringArrayListExtra("subjectArgument") as java.util.ArrayList<String>

        val listview = findViewById<ListView>(binding.lvsubject.id)
        adapter = Argment_Fragment(this, arrayList);
        listview.adapter = adapter

    }
}
