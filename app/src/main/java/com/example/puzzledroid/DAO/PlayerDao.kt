package com.example.puzzledroid.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.puzzledroid.DomainEntities.Player

@Dao
interface PlayerDao {

    //Read operations

    @Query("SELECT * FROM PlayerTable ORDER BY Score ASC")
     fun getAll(): List<Player>



    //Other Crud Operations
    @Insert
      fun insert( player: Player)

}