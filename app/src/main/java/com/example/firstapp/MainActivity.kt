package com.example.firstapp

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var counter = 0
    lateinit var textView: TextView

    private fun updateCounterTextView() {
        val formattedTextString : String = when {
            counter >= 0 && counter < 10 -> {
                String.format("%02d", counter)
            }
            counter >= 10 -> {
                counter.toString()
            }
            else -> {
                counter.toString()
            }

        }
        textView.text = formattedTextString
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView = findViewById(R.id.counter)
        val addButton: Button = findViewById(R.id.btnAdd)
        val reduceButton: Button = findViewById(R.id.btnReduce)

        addButton.setOnClickListener {
            counter++
            updateCounterTextView()
        }
        reduceButton.setOnClickListener {
            counter--
            updateCounterTextView()
        }
    }
}