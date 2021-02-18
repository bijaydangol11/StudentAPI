package com.kiran.student.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder

class DashboardActivity : AppCompatActivity() {
private lateinit var btnAdd:Button
private lateinit var btnView:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnAdd=findViewById(R.id.btnaddstudent)
        btnView=findViewById(R.id.btnviewstudent)

        btnAdd.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AddstudentActivity::class.java
                )
            )

        }

        btnView.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ViewstudentActivity::class.java
                )
            )
        }




    }



}