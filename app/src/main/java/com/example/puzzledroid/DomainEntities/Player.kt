package com.example.puzzledroid.DomainEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlayerTable")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "Name") var Name: String,
    @ColumnInfo(name = "Score") var Score: Int,



)
