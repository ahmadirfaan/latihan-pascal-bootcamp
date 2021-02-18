package com.pascal.beamvolume

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CounterInterface {

    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: ShowCounterFragment
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterFragment = fragment1 as CounterFragment
        counterShowFragment = fragment2 as ShowCounterFragment
        println("MAIN ACTIVITY THIS : $this")
    }

    fun toSecondActivity(view: View) {
        startActivity(Intent(this,SecondActivity::class.java))
    }

    override fun increment() {
        counter++
        println("COUNTER $counter")
        counterShowFragment.notifyShowCounter(counter)
    }

    override fun decrement() {
        counter--
        println("COUNTER $counter")
        counterShowFragment.notifyShowCounter(counter)
    }


}