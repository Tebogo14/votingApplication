package com.example.votingapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.votingapplication.databinding.LandingPageBinding
import com.example.votingapplication.fragment.Landing_fragment
import com.example.votingapplication.models.Const
import com.example.votingapplication.models.Subject
import org.json.JSONArray
import org.json.JSONObject


class Landing : AppCompatActivity() {

    private lateinit var binding: LandingPageBinding

    var arrayList: ArrayList<Subject> = ArrayList()
    var adapter: Landing_fragment? = null
    val c:Const = Const()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userid = getIntent().getStringExtra("userId")

        val listview = findViewById<ListView>(binding.lvsubject.id)
        val queue: RequestQueue = Volley.newRequestQueue(this)

        val url =  c.host +"/api/Vote/getVoteSubjects?userId=" + userid

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                val json = JSONArray(response)

                for (i in 0 until json.length()) {

                    val subject:Subject = Subject()

                    subject.description = json.getJSONObject(i).getString("description")
                    subject.title = json.getJSONObject(i).getString("title")
                    subject.subjectArgument = json.getJSONObject(i).getJSONArray("subjectArguments")

                    arrayList.add(subject)
                }

                adapter = Landing_fragment(this, arrayList);
                listview.adapter = adapter
            },
            Response.ErrorListener { error ->
                // Handle error
                Toast.makeText(this, "Username and Password does not exist", Toast.LENGTH_LONG).show()
                print(error)
            })
            queue.add(stringRequest)



    }


}




