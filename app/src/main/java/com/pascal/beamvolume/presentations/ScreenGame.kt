package com.pascal.beamvolume.presentations

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.pascal.beamvolume.R
import kotlinx.android.synthetic.main.fragment_screen_game.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ScreenGame(var player1: String, var player2: String) : Fragment() {

    private var activePlayer = player1
    private var checkWinnerPlayer1 = ArrayList<Int>()
    private var checkWinnerPlayer2 = ArrayList<Int>()

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
            playGame(1, it as Button)
        }
        button01.setOnClickListener {
            playGame(2, it as Button)

        }
        button02.setOnClickListener {
            playGame(3, it as Button)

        }
        button10.setOnClickListener {
            playGame(4, it as Button)
        }
        button11.setOnClickListener {
            playGame(5, it as Button)
        }
        button12.setOnClickListener {
            playGame(6, it as Button)
        }
        button20.setOnClickListener {
            playGame(7, it as Button)
        }
        button21.setOnClickListener {
            playGame(8, it as Button)
        }
        button22.setOnClickListener {
            playGame(9, it as Button)
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(player1: String, player2: String) = ScreenGame(player1, player2)
    }

    private fun playGame(cellID: Int, buttonSelected: Button) {
        if (activePlayer == player1) {
            buttonSelected.text = "X"
            checkWinnerPlayer1.add(cellID)
        } else {
            buttonSelected.text = "O"
            checkWinnerPlayer2.add(cellID)
        }
        checkWinner()
        switchPlayer()
        showPlayerTurn(activePlayer)
        buttonSelected.isEnabled = false
        for (i in checkWinnerPlayer1) {
            Log.i("ARRAY CHECK WINNER PLAYER 1 ", "${i.toString()}")
        }
        for (i in checkWinnerPlayer2) {
            Log.i("ARRAY CHECK WINNER PLAYER 2 ", "${i.toString()}")
        }
    }

    private fun checkWinner() {
        var winner = -1
        //Check Row 1
        if (checkWinnerPlayer1.contains(1) && checkWinnerPlayer1.contains(2) && checkWinnerPlayer1.contains(3)) {
            winner = 1
        }
        //Check Row 1
        if (checkWinnerPlayer2.contains(1) && checkWinnerPlayer2.contains(2) && checkWinnerPlayer2.contains(3)) {
            winner = 2
        }
        //Check Row 2
        if (checkWinnerPlayer1.contains(4) && checkWinnerPlayer1.contains(5) && checkWinnerPlayer1.contains(6)) {
            winner = 1
        }
        //Check Row 2
        if (checkWinnerPlayer2.contains(4) && checkWinnerPlayer2.contains(5) && checkWinnerPlayer2.contains(6)) {
            winner = 2
        }
        //Check Row 3
        if (checkWinnerPlayer1.contains(7) && checkWinnerPlayer1.contains(8) && checkWinnerPlayer1.contains(9)) {
            winner = 1
        }
        //Check Row 3
        if (checkWinnerPlayer2.contains(7) && checkWinnerPlayer2.contains(8) && checkWinnerPlayer2.contains(9)) {
            winner = 2
        }
        //Check Col 1
        if (checkWinnerPlayer1.contains(1) && checkWinnerPlayer1.contains(4) && checkWinnerPlayer1.contains(7)) {
            winner = 1
        }
        //Check Col 1
        if (checkWinnerPlayer2.contains(1) && checkWinnerPlayer2.contains(4) && checkWinnerPlayer2.contains(7)) {
            winner = 2
        }
        //Check Col 2
        if (checkWinnerPlayer1.contains(2) && checkWinnerPlayer1.contains(5) && checkWinnerPlayer1.contains(8)) {
            winner = 1
        }
        //Check Col 2
        if (checkWinnerPlayer2.contains(2) && checkWinnerPlayer2.contains(5) && checkWinnerPlayer2.contains(8)) {
            winner = 2
        }
        //Check Col 3
        if (checkWinnerPlayer1.contains(3) && checkWinnerPlayer1.contains(6) && checkWinnerPlayer1.contains(9)) {
            winner = 1
        }
        //Check Col 3
        if (checkWinnerPlayer2.contains(3) && checkWinnerPlayer2.contains(6) && checkWinnerPlayer2.contains(9)) {
            winner = 2
        }
        //Check Diagonal 1
        if (checkWinnerPlayer1.contains(1) && checkWinnerPlayer1.contains(5) && checkWinnerPlayer1.contains(9)) {
            winner = 1
        }
        //Check Diagonal 1
        if (checkWinnerPlayer2.contains(1) && checkWinnerPlayer2.contains(5) && checkWinnerPlayer2.contains(9)) {
            winner = 2
        }
        //Check Diagonal 2
        if (checkWinnerPlayer1.contains(3) && checkWinnerPlayer1.contains(5) && checkWinnerPlayer1.contains(7)) {
            winner = 1
        }
        //Check Diagonal 2
        if (checkWinnerPlayer2.contains(3) && checkWinnerPlayer2.contains(5) && checkWinnerPlayer2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(requireContext(), "${player1.toUpperCase()} MENANG COKKK...", Toast.LENGTH_LONG).show()
                makeAllButtonDisabled()
                viewLifecycleOwner.lifecycleScope.launch{
                    delay(5000)
                    resetList()
                    makeAllButtonEnabled()
                }
                activePlayer = player2
            } else {
                Toast.makeText(requireContext(), "${player2.toUpperCase()} MENANG COKKK...", Toast.LENGTH_LONG).show()
                makeAllButtonDisabled()
                viewLifecycleOwner.lifecycleScope.launch{
                    delay(5000)
                    resetList()
                    makeAllButtonEnabled()
                }
                activePlayer = player2
            }
        }

    }


    private fun showPlayerTurn(player: String) {
        playerturn.text = player + " Turn"
    }

    private fun makeAllButtonDisabled() {
        button00.isEnabled = false
        button01.isEnabled = false
        button02.isEnabled = false
        button10.isEnabled = false
        button11.isEnabled = false
        button12.isEnabled = false
        button21.isEnabled = false
        button22.isEnabled = false
        button20.isEnabled = false
        resetButtonText()
    }

    private fun makeAllButtonEnabled() {
        button00.isEnabled = true
        button01.isEnabled = true
        button02.isEnabled = true
        button10.isEnabled = true
        button11.isEnabled = true
        button12.isEnabled = true
        button21.isEnabled = true
        button22.isEnabled = true
        button20.isEnabled = true
    }

    private fun resetButtonText() {
        button00.text = ""
        button01.text = ""
        button02.text = ""
        button10.text = ""
        button11.text = ""
        button12.text = ""
        button21.text = ""
        button22.text = ""
        button20.text = ""
    }

    private fun resetList() {
        checkWinnerPlayer1.clear()
        checkWinnerPlayer2.clear()
    }

    private fun switchPlayer() {
        if (activePlayer == player1) {
            activePlayer = player2
        } else {
            activePlayer = player1
        }
    }
}