package com.example.fallingcircle

import android.R.attr.x
import android.R.attr.y
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var circle: Circle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circle = findViewById(R.id.circle)
    }
}