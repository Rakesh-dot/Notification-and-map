package com.rakesh.notificationwear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : WearableActivity() {

    private lateinit var btnAdd: Button
    private lateinit var et2: EditText
    private lateinit var et1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        btnAdd=findViewById(R.id.btnAdd)
        
        btnAdd.setOnClickListener { 
            var num1=et1.text.toString().toInt()
            var num2=et2.text.toString().toInt()
            var add=num1+num2
            Toast.makeText(this, "the sum is $add", Toast.LENGTH_SHORT).show()
        }

        // Enables Always-on
        setAmbientEnabled()
    }
}