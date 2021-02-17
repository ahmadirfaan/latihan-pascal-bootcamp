package com.pascal.beamvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var resultTextView: MaterialTextView
    private var number = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun clickIncrement(view: View) {
        number++
        display(number)
    }

    fun clickDecrement(view: View) {
        number--
        display(number)
    }

    fun display(number : Int ) {
        val displayInteger : MaterialTextView = findViewById(R.id.resultTextView)
        displayInteger.setText(" " + number)
    }
}


}