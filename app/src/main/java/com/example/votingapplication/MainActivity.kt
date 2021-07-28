package com.example.votingapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import com.example.votingapplication.databinding.LoginPageBinding
import com.example.votingapplication.databinding.ProgressViewBinding
import com.example.votingapplication.models.Const
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding
    private lateinit var progressbinding: ProgressViewBinding

    // Instantiate the RequestQueue with the cache and network. Start the queue.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressbinding = ProgressViewBinding.inflate(layoutInflater)

        val frameLayout = findViewById<View>(progressbinding.progressView.id);

        val c:Const = Const()
        val button = findViewById<Button>(binding.btnLogin.id);

        button.setOnClickListener {

            val queue: RequestQueue = Volley.newRequestQueue(this)
            var email = findViewById<EditText>(binding.editTextTextEmailAddress.id).text;
            var password = findViewById<EditText>(binding.editTextTextPassword.id).text;

            val url =  c.host +"/api/Vote/User/logIn?email="+email+"&password=" + password;

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->

                    val jsonObject = JSONObject(response)

                    val userid = jsonObject.getString("id").toString()

                    frameLayout.isVisible = true;

                    if (userid !== null) {
                        val intent = Intent(applicationContext, Landing::class.java)
                        intent.putExtra("userId", userid)

                        frameLayout.isVisible = false;
                        startActivity(intent)
                    }
                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this, "Username and Password does not exist", Toast.LENGTH_LONG).show()
                    print(error)
                })

            queue.add(stringRequest)


        }
    }

    fun sendRequest(url:String)
    {

    }



}