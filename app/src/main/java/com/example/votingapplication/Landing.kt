package com.example.votingapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.votingapplication.databinding.LandingPageBinding
import com.example.votingapplication.fragment.Landing_fragment


class Landing : AppCompatActivity() {

    private lateinit var binding: LandingPageBinding

    var arrayList: ArrayList<String> = ArrayList()
    var adapter: Landing_fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listview = findViewById<ListView>(binding.lvsubject.id)

        arrayList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu cursus diam. Vivamus pulvinar lacus lorem, vitae egestas risus egestas et. Aliquam gravida in nulla in molestie")
        arrayList.add("TMorbi viverra dui vulputate porttitor pellentesque. Curabitur mattis metus nec nisi ultricies, ac consequat mi fermentum. Aliquam blandit lacus est, ac aliquam mi ultricies ac.")
        arrayList.add("Aliquam vehicula ac dui non egestas. Duis rhoncus turpis quis augue iaculis, id vehicula nunc ullamcorper Mauris eros nulla, vestibulum ut maximus eget, dictum vel purus. Integer eget mauris eu nisl lobortis")
        arrayList.add("Nulla facilisi. In venenatis dui at finibus malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla varius erat a dolor efficitur tempor.")

        adapter = Landing_fragment(this, arrayList);
        listview.adapter = adapter

    }


}


