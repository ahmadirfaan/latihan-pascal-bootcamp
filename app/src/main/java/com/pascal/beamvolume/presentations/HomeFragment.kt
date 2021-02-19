package com.pascal.beamvolume.presentations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pascal.beamvolume.R
import com.pascal.beamvolume.utils.OnNavigationListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startbutton.setOnClickListener {
            val player1Text = inputplayer1.text
            val player2Text = inputplayer2.text
            onNavigationListener.onRegistrationPlayer(
                player1 = player1Text.toString(),
                player2 = player2Text.toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) = HomeFragment(onNavigationListener)
    }
}