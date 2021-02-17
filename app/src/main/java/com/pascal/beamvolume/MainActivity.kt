package com.pascal.beamvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editWidth: TextInputEditText
    private lateinit var editHeight: TextInputEditText
    private lateinit var editLength: TextInputEditText
    private lateinit var btnCalculate: MaterialButton
    private lateinit var tvResult: MaterialTextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWidth = findViewById(R.id.inputlebar)
        editHeight = findViewById(R.id.inputTinggi)
        editLength = findViewById(R.id.inputPanjang)
        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }
    }


}