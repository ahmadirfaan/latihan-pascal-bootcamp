package com.pascal.beamvolume.presentations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.pascal.beamvolume.R
import kotlinx.android.synthetic.main.fragment_screen_game.*


class ScreenGame(var player1: String, var player2: String) : Fragment() {

    private var activePlayer = player1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_screen_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPlayerTurn(activePlayer)
        button00.setOnClickListener {
            playGame(it as Button)
        }
        button01.setOnClickListener {
            playGame(it as Button)
        }
        button02.setOnClickListener {
            playGame(it as Button)
        }
        button10.setOnClickListener {
            playGame(it as Button)
        }
        button11.setOnClickListener {
            playGame(it as Button)
        }
        button12.setOnClickListener {
            playGame(it as Button)
        }
        button20.setOnClickListener {
            playGame(it as Button)
        }
        button21.setOnClickListener {
            playGame(it as Button)
        }
        button22.setOnClickListener {
            playGame(it as Button)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(player1: String, player2: String) = ScreenGame(player1, player2)
    }

    private fun playGame(buttonSelected: Button) {
        if (activePlayer == player1) {
            buttonSelected.text = "X"
        } else {
            buttonSelected.text = "O"
        }
        switchPlayer()
        showPlayerTurn(activePlayer)
    }

    private fun showPlayerTurn(player: String) {
        playerturn.text = player + " Turn"
    }

    private fun switchPlayer() {
        if (activePlayer == player1) {
            activePlayer = player2
        } else {
            activePlayer = player1
        }
    }
}