package com.pascal.beamvolume

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BoardActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        nameTextView = findViewById(R.id.username_text_input)
        val name = intent.getStringExtra(MainActivity.USER_NAME)
        nameTextView.text = name
    }
}