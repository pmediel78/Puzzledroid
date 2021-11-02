package com.example.puzzledroid

import android.app.Application
import androidx.room.Room
import com.example.puzzledroid.Dbs.PlayerDb

class PlayerApp : Application(){
    val room = Room
                .databaseBuilder(this,PlayerDb::class.java,"player")
                .build()
}