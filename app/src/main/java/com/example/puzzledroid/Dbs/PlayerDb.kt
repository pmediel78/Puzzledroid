package com.example.puzzledroid.Dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.puzzledroid.DAO.PlayerDao
import com.example.puzzledroid.DomainEntities.Player


@Database(
    entities = [Player::class],
    version = 1,
    exportSchema = false

)
abstract class PlayerDb: RoomDatabase() {

    abstract fun playerDao(): PlayerDao


}