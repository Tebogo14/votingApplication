package com.example.votingapplication.fragment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.votingapplication.R
import com.example.votingapplication.Vote
import com.example.votingapplication.models.SubjectArgument

class Argment_Fragment(private val context: Context, private val arrayList: java.util.ArrayList<String>) :
BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.fragment_argument, parent, false)

        val subject = convertView.findViewById<TextView>(R.id.textView3)

        subject.text = arrayList[position];

        var viewButton = convertView.findViewById<Button>(R.id.btnviewArg)

        viewButton.setOnClickListener {
            Toast.makeText(context, subject.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, Vote::class.java)
            intent.putExtra("argument", subject.text.toString())
            ContextCompat.startActivity(context, intent, null)
        }

        return convertView
    }
}