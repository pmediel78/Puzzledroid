package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.puzzledroid.Dbs.PlayerDb
import com.example.puzzledroid.DomainEntities.Player
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetButtonOnClickListeners();



        val player1 = Player(1,"Marc",34)
        val player2 = Player(2,"Pedro",20)
        val player3 = Player(3,"Juan",24)
        val player4 = Player(4,"Toni",28)
        val player5 = Player(5,"Jordi",7)






    }

    fun SetButtonOnClickListeners() {
        RankingButtonClick()
        JuegoButtonClick()
        AyudaButtonClick()
    }

    private fun JuegoButtonClick() {
        val juegoBtn: Button = findViewById(R.id.Juegobtn)
        juegoBtn.setOnClickListener {
            val intent = Intent(this, Juego3Activity::class.java)
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