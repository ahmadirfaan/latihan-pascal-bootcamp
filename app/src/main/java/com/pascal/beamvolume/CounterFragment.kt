package com.pascal.beamvolume

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment() {

    private var showCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as MainActivity

        increaseButton.setOnClickListener {
            if (showCounter >= 0) {
                decreaseButton.setEnabled(true)
            }
            showCounter++
            activity.controllerData(showCounter)
        }

        decreaseButton.setOnClickListener {
            showCounter--
            if (showCounter < 0) {
                val myToast =
                    Toast.makeText(requireContext(), "Tidak bisa negative dong", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.LEFT, 200, 200)
                myToast.show()
                decreaseButton.setEnabled(false)
                showCounter = 0
            }
            activity.controllerData(showCounter)
        }

    }


    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }
}