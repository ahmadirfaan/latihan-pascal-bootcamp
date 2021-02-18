package com.pascal.beamvolume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment() {

    private var showCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as MainActivity

        increaseButton.setOnClickListener {
            showCounter++
            activity.controllerData(showCounter)
        }
        decreaseButton.setOnClickListener( {
            showCounter--
            activity.controllerData(showCounter)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }
}