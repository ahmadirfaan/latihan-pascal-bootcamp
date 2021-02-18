package com.pascal.beamvolume

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment(), View.OnClickListener {

    private lateinit var counterHandler: CounterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterHandler = activity as CounterInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        increaseButton.setOnClickListener(this)
        decreaseButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            increaseButton -> {
                println("INCREASE BUTTON DIPANGGIL")
                counterHandler.increment()
            }
            decreaseButton -> {
                println("DECREASE BUTTON DIPANGGIL")
                counterHandler.decrement()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }
}