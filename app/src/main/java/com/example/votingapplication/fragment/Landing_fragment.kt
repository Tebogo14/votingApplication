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
import com.example.votingapplication.Arguments
import com.example.votingapplication.R
import com.example.votingapplication.models.Subject
import com.example.votingapplication.models.SubjectArgument

class Landing_fragment (private val context: Context, private val arrayList: java.util.ArrayList<Subject>) :
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
        convertView = LayoutInflater.from(context).inflate(R.layout.fragment_subject, parent, false)

        val description = convertView.findViewById<TextView>(R.id.textView3)
        val title = convertView.findViewById<TextView>(R.id.textView2)

        description.text = arrayList.get(position).description;
        title.text = arrayList.get(position).title


        val subjectArguments: ArrayList<String> = ArrayList()

        for (i in 0 until arrayList.get(position).subjectArgument.length()) {

            if(arrayList.get(position).subjectArgument.length() != 0) {
                subjectArguments.add(arrayList.get(position).subjectArgument.getJSONObject(i)
                        .getString("argument"))
            }
        }

        var viewButton = convertView.findViewById<Button>(R.id.btnviewArg)

        viewButton.setOnClickListener {
            val intent = Intent(context, Arguments::class.java)
            intent.putExtra("subject", description.text.toString())
            intent.putExtra("subjectArgument", subjectArguments)
            ContextCompat.startActivity(context, intent, null)
        }

        return convertView
    }
}