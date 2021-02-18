package com.pascal.beamvolume

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BoardActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private val boardActivity = "BOARD ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        nameTextView = findViewById(R.id.name_text_view)
        val name = intent.getStringExtra(MainActivity.USER_NAME)
        nameTextView.text = name
    }

    override fun onStart() {
        super.onStart()
        Log.i(boardActivity, "onStart() CALLED")
    }

    override fun onResume() {
        super.onResume()
        Log.i(boardActivity, "onResume() CALLED")
    }

    override fun onPause() {
        super.onPause()
        Log.i(boardActivity, "onPause() CALLED")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(boardActivity, "onDestroy() CALLED")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i(boardActivity, "OnRestart() CALLED")
    }
}