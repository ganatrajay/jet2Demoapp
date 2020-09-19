package com.example.jet2demoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jet2demoapp.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.frag_container, MainFargment()).commit()
    }
}