package com.pascal.beamvolume

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var userNameText : TextInputEditText

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


}