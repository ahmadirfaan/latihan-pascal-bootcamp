package com.pascal.beamvolume

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var userNameText : TextInputEditText
    private val activityName = "MAIN ACTIVITY"

    companion object {
        const val USER_NAME = "USER_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameText = findViewById(R.id.username_text_input)
    }

    fun moveToSecondActivity(view: View) {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra(USER_NAME, userNameText.text.toString())
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i(activityName, "onStart() CALLED")
    }

    override fun onResume() {
        super.onResume()
        Log.i(activityName, "onResume() CALLED")
    }

    override fun onPause() {
        super.onPause()
        Log.i(activityName, "onPause() CALLED")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(activityName, "onDestroy() CALLED")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i(activityName, "OnRestart() CALLED")
    }


}