package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class JuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("hola")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //Button OnClickListeners


        val puzzle = Puzzle(3,3)
        puzzle.inicializar()

    }
}