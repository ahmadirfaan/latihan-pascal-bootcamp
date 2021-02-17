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
        btnCalculate = findViewById(R.id.materialButtonResult)
        tvResult = findViewById(R.id.resultTextView)
        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.materialButtonResult) {
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()
            val inputLength = editLength.text.toString().trim()

            var isEmptyField = false

            if(inputWidth.isEmpty()) {
                isEmptyField = true
                editWidth.error = "Harap masukkan lebar dari Balok"
            }
            if(inputHeight.isEmpty()) {
                isEmptyField = true
                editHeight.error = "Harap masukkan tinggi dari Balok"
            }
            if(inputLength.isEmpty()) {
                isEmptyField = true
                editLength.error = "Harap masukkan panjang dari Balok"
            }

            if(!isEmptyField) {
                val volume = inputWidth.toDouble() * inputHeight.toDouble() * inputLength.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }


}