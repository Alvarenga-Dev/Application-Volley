package com.alvarengadev.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val context = this@MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(context)
        queue.add(stringRequest())
    }

    @SuppressLint("SetTextI18n")
    private fun stringRequest(url: String = "https://www.google.com"): StringRequest = StringRequest(
        Request.Method.GET,
        url,
        Response.Listener<String> { response ->
            textView.text = "Response is: ${response.subSequence(0, 500)}"
        },
        Response.ErrorListener { error ->
            textView.text = "That didn`t work :( - ${error.networkResponse.statusCode}"
        }
    )
}