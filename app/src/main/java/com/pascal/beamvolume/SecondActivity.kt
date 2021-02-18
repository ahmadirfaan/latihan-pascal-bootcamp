package com.pascal.beamvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener, CounterInterface {

    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: ShowCounterFragment
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        counterFragmentButton.setOnClickListener(this)
        counterShowFragmentButton.setOnClickListener(this)
        counterFragment = CounterFragment()
        counterShowFragment = ShowCounterFragment()
        //Penempelanan fragment secara dinamis, bisa mengunakan FrameLayout dengan id fragmentContainer
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, counterFragment).commit()
    }

    override fun onClick(v: View?) {
        when(v) {
            counterFragmentButton -> {
                switchFragment(counterFragment)
            }
            counterShowFragmentButton -> {
                counterShowFragment.counter = counter
                switchFragment(counterShowFragment)
            }
        }
    }

    private fun switchFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun increment() {
        counter++
    }

    override fun decrement() {
        counter--
    }

}