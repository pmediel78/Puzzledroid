package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println(0);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetButtonOnClickListeners();
    }

    fun SetButtonOnClickListeners() {
        RankingButtonClick()
        JuegoButtonClick()
        AyudaButtonClick()
    }

    private fun JuegoButtonClick() {
        val juegoBtn: Button = findViewById(R.id.Juegobtn)
        juegoBtn.setOnClickListener {
            val intent = Intent(this, Juego2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun RankingButtonClick() {
        val rankingBtn: Button = findViewById(R.id.Rankingbtn)
        rankingBtn.setOnClickListener {
            val intent = Intent(this, RankingActivity::class.java)
            startActivity(intent)
        }
    }
    private fun AyudaButtonClick() {
        val rankingBtn: Button = findViewById(R.id.Ayudabtn)
        rankingBtn.setOnClickListener {
            val intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent)
        }
    }

}