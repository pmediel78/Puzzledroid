package com.example.puzzledroid


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)


        SetButtonOnClickListeners()

        //SetBackButton Al ActionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }



    fun SetButtonOnClickListeners() {

    }


}