package com.pascal.beamvolume.presentations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pascal.beamvolume.R
import com.pascal.beamvolume.utils.OnNavigationListener
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(), OnNavigationListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var screenGame: ScreenGame


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment.newInstance(this)

        println("MAIN ACTIVITY THIS : $this")
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, homeFragment).commit()
    }


    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun onRegistrationPlayer(player1: String, player2: String) {
       screenGame = ScreenGame.newInstance(player1, player2)
        switchFragment(screenGame)
    }



}