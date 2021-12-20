package com.example.puzzledroid


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_ranking.*
import kotlinx.android.synthetic.main.activity_win.*
import kotlinx.android.synthetic.main.activity_win.NameToSave
import com.google.firebase.firestore.QueryDocumentSnapshot

import com.google.firebase.firestore.QuerySnapshot

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.Query


class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        SetButtonOnClickListeners()

        //SetBackButton Al ActionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var rankingPosition = 1
        val db = FirebaseFirestore.getInstance()
        db.collection( "Scores")
            .orderBy("Score", Query.Direction.DESCENDING)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userScores = mutableListOf<UserContract.UserDTO>()
                    for (document in task.result!!) {

                        val name = document.data.get("User") as String
                        val score = document.data.get("Score") as Long
                        Log.d("prueba", " entra " )
                        val userScore = UserContract.UserDTO(rankingPosition, name, score.toInt())
                        userScores.add(userScore)
                        rankingPosition += 1
                    }
                    FirstRanking(userScores)
                } else {
                    Log.w("prueba", "Error getting documents.", task.exception)
                }
            }

        /*val userScoreList = GetFirebaseData()*/
        /*FirstRanking(userScoreList)*/
    }



    fun SetButtonOnClickListeners() {
        SearchUserClick()
    }
    private fun SearchUserClick() {
        val searchbtn: Button = findViewById(R.id.SearchUserBtn)
        searchbtn.setOnClickListener {
            var list=  GetDbData()

            UpdateRankingWithSearch(list)
        }

    }

    fun GetFirebaseData() : List<UserContract.UserDTO> {
        val userScores = mutableListOf<UserContract.UserDTO>()
        var rankingPosition = 1
        val db = FirebaseFirestore.getInstance()
        db.collection("Scores")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val name = document.data.get("User") as String
                        val score = document.data.get("Score") as String
                        Log.d("prueba", " entra " )
                        val userScore = UserContract.UserDTO(rankingPosition, name, score.toInt())
                        userScores.add(userScore)
                        rankingPosition += 1
                    }
                } else {
                    Log.w("prueba", "Error getting documents.", task.exception)
                }
            }
        return userScores
    }

    fun GetDbData() : List<UserContract.UserDTO> {
        val dbHelper = UserContract.UserDbHelper(applicationContext)
        val db = dbHelper.readableDatabase

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(BaseColumns._ID, UserContract.UserEntry.COLUMN_NAME_USERNAME, UserContract.UserEntry.COLUMN_NAME_SCORE)



        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${UserContract.UserEntry.COLUMN_NAME_SCORE} ASC"

        val cursor = db.query(
            UserContract.UserEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order

        )

        var rankingPosition = 1
        val userScores = mutableListOf<UserContract.UserDTO>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_NAME_USERNAME))
                val score = getInt(getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_NAME_SCORE))

                val userScore = UserContract.UserDTO(rankingPosition,name,score)
                userScores.add(userScore)
                rankingPosition += 1
            }
        }
        cursor.close()


     return userScores
    }

    fun FirstRanking(list : List<UserContract.UserDTO> ) {

        var userRankingPosition =0

        //Gather references
        val Pos1 = findViewById(R.id.Pos1) as TextView
        val User1 = findViewById(R.id.User1) as TextView
        val Score1 = findViewById(R.id.Score1) as TextView

        val Pos2 = findViewById(R.id.Pos2) as TextView
        val User2 = findViewById(R.id.User2) as TextView
        val Score2 = findViewById(R.id.Score2) as TextView

        val Pos3 = findViewById(R.id.Pos3) as TextView
        val User3 = findViewById(R.id.User3) as TextView
        val Score3 = findViewById(R.id.Score3) as TextView

        val Pos4 = findViewById(R.id.Pos4) as TextView
        val User4 = findViewById(R.id.User4) as TextView
        val Score4 = findViewById(R.id.Score4) as TextView

        val Pos5 = findViewById(R.id.Pos5) as TextView
        val User5 = findViewById(R.id.User5) as TextView
        val Score5 = findViewById(R.id.Score5) as TextView


        if(list[userRankingPosition] != list.lastOrNull()){

            Pos1.text = list[userRankingPosition].Position.toString()
            User1.text = list[userRankingPosition].Name
            Score1.text = list[userRankingPosition].Score.toString()

            if(list[userRankingPosition +1] != list.lastOrNull()){

                Pos2.text = list[userRankingPosition+1].Position.toString()
                User2.text = list[userRankingPosition+1].Name
                Score2.text = list[userRankingPosition+1].Score.toString()
            }
            if(list[userRankingPosition +2] != list.lastOrNull()){

                Pos3.text = list[userRankingPosition+2].Position.toString()
                User3.text = list[userRankingPosition+2].Name
                Score3.text = list[userRankingPosition+2].Score.toString()
            }
            if(list[userRankingPosition +3] != list.lastOrNull()){

                Pos4.text = list[userRankingPosition+3].Position.toString()
                User4.text = list[userRankingPosition+3].Name
                Score4.text = list[userRankingPosition+3].Score.toString()
            }
            if(list[userRankingPosition +4] != list.lastOrNull()){

                Pos5.text = list[userRankingPosition+4].Position.toString()
                User5.text = list[userRankingPosition+4].Name
                Score5.text = list[userRankingPosition+4].Score.toString()
            }

        }
    }

    fun UpdateRankingWithSearch(list : List<UserContract.UserDTO> ) {

        //Search for user in list
        var containsUser = false
        var userRankingPosition =0
        val LastRankingPosition = list.last().Position -1
        val nameToSearch = NameToSearch.editText?.text.toString()
        for (item in list) {
            if(item.Name ==  nameToSearch){
                containsUser = true
                userRankingPosition = item.Position -1
                break
            }

        }


        if(containsUser){
            //Gather references
            val Pos1 = findViewById(R.id.Pos1) as TextView
            val User1 = findViewById(R.id.User1) as TextView
            val Score1 = findViewById(R.id.Score1) as TextView

            val Pos2 = findViewById(R.id.Pos2) as TextView
            val User2 = findViewById(R.id.User2) as TextView
            val Score2 = findViewById(R.id.Score2) as TextView

            val Pos3 = findViewById(R.id.Pos3) as TextView
            val User3 = findViewById(R.id.User3) as TextView
            val Score3 = findViewById(R.id.Score3) as TextView

            val Pos4 = findViewById(R.id.Pos4) as TextView
            val User4 = findViewById(R.id.User4) as TextView
            val Score4 = findViewById(R.id.Score4) as TextView

            val Pos5 = findViewById(R.id.Pos5) as TextView
            val User5 = findViewById(R.id.User5) as TextView
            val Score5 = findViewById(R.id.Score5) as TextView


            CleanRankingData(
                Pos1,
                User1,
                Score1,
                Pos2,
                User2,
                Score2,
                Pos3,
                User3,
                Score3,
                Pos4,
                User4,
                Score4,
                Pos5,
                User5,
                Score5
            )
            SetRankingData(
                userRankingPosition,
                LastRankingPosition,
                Pos1,
                list,
                User1,
                Score1,
                Pos2,
                User2,
                Score2,
                Pos3,
                User3,
                Score3,
                Pos4,
                User4,
                Score4,
                Pos5,
                User5,
                Score5
            )



        }
    }

    private fun SetRankingData(
        userRankingPosition: Int,
        LastRankingPosition: Int,
        Pos1: TextView,
        list: List<UserContract.UserDTO>,
        User1: TextView,
        Score1: TextView,
        Pos2: TextView,
        User2: TextView,
        Score2: TextView,
        Pos3: TextView,
        User3: TextView,
        Score3: TextView,
        Pos4: TextView,
        User4: TextView,
        Score4: TextView,
        Pos5: TextView,
        User5: TextView,
        Score5: TextView
    ) {
        if (userRankingPosition != LastRankingPosition) {

            Pos1.text = list[userRankingPosition].Position.toString()
            User1.text = list[userRankingPosition].Name
            Score1.text = list[userRankingPosition].Score.toString()
            if (userRankingPosition + 1 != LastRankingPosition) {

                Pos2.text = list[userRankingPosition + 1].Position.toString()
                User2.text = list[userRankingPosition + 1].Name
                Score2.text = list[userRankingPosition + 1].Score.toString()

                if (userRankingPosition + 2 != LastRankingPosition) {

                    Pos3.text = list[userRankingPosition + 2].Position.toString()
                    User3.text = list[userRankingPosition + 2].Name
                    Score3.text = list[userRankingPosition + 2].Score.toString()

                    if (userRankingPosition + 3 != LastRankingPosition) {

                        Pos4.text = list[userRankingPosition + 3].Position.toString()
                        User4.text = list[userRankingPosition + 3].Name
                        Score4.text = list[userRankingPosition + 3].Score.toString()

                        if (userRankingPosition + 4 != LastRankingPosition) {

                            Pos5.text = list[userRankingPosition + 4].Position.toString()
                            User5.text = list[userRankingPosition + 4].Name
                            Score5.text = list[userRankingPosition + 4].Score.toString()
                        } else {
                            Pos5.text = list[userRankingPosition + 4].Position.toString()
                            User5.text = list[userRankingPosition + 4].Name
                            Score5.text = list[userRankingPosition + 4].Score.toString()
                        }
                    } else {
                        Pos4.text = list[userRankingPosition + 3].Position.toString()
                        User4.text = list[userRankingPosition + 3].Name
                        Score4.text = list[userRankingPosition + 3].Score.toString()
                    }
                } else {
                    Pos3.text = list[userRankingPosition + 2].Position.toString()
                    User3.text = list[userRankingPosition + 2].Name
                    Score3.text = list[userRankingPosition + 2].Score.toString()
                }
            } else {
                Pos2.text = list[userRankingPosition + 1].Position.toString()
                User2.text = list[userRankingPosition + 1].Name
                Score2.text = list[userRankingPosition + 1].Score.toString()
            }
        } else {
            Pos1.text = list[userRankingPosition].Position.toString()
            User1.text = list[userRankingPosition].Name
            Score1.text = list[userRankingPosition].Score.toString()
        }
    }

    private fun CleanRankingData(
        Pos1: TextView,
        User1: TextView,
        Score1: TextView,
        Pos2: TextView,
        User2: TextView,
        Score2: TextView,
        Pos3: TextView,
        User3: TextView,
        Score3: TextView,
        Pos4: TextView,
        User4: TextView,
        Score4: TextView,
        Pos5: TextView,
        User5: TextView,
        Score5: TextView
    ) {
        Pos1.text = ""
        User1.text = ""
        Score1.text = ""

        Pos2.text = ""
        User2.text = ""
        Score2.text = ""

        Pos3.text = ""
        User3.text = ""
        Score3.text = ""

        Pos4.text = ""
        User4.text = ""
        Score4.text = ""

        Pos5.text = ""
        User5.text = ""
        Score5.text = ""
    }
}