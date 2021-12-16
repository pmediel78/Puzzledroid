package com.example.puzzledroid

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_win.*
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.FirebaseUser





class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        SetButtonOnClickListeners()
    }
    fun SetButtonOnClickListeners() {
        JuegoButtonClick()
    }

    private fun JuegoButtonClick() {
        val juegoBtn: Button = findViewById(R.id.Juegobtn)
        juegoBtn.setOnClickListener {



            val Contador_1= intent.getStringExtra("Counter")?.toInt()
            var Counter = Contador_1

            val name = NameToSave.editText?.text.toString()

            val db: FirebaseFirestore = FirebaseFirestore.getInstance()

            val user = FirebaseAuth.getInstance().currentUser
            val userScore: MutableMap<String, Any> = HashMap()
            userScore["Score"] = Counter.toString()
            userScore["User"] = user?.displayName.toString()

            db.collection("Scores")
                .add(userScore)



            /**


            val dbHelper = UserContract.UserDbHelper(applicationContext)

            val db = dbHelper.writableDatabase

            // Create a new map of values, where column names are the keys
            val values = ContentValues().apply {
                put(UserContract.UserEntry.COLUMN_NAME_USERNAME, name)
                put(UserContract.UserEntry.COLUMN_NAME_SCORE, Counter)
            }

            // Insert the new row, returning the primary key value of the new row
            val newRowId = db?.insert(UserContract.UserEntry.TABLE_NAME, null, values)


            val dbread = dbHelper.readableDatabase

            // Define a projection that specifies which columns from the database
            // you will actually use after this query.
            val projection = arrayOf(BaseColumns._ID, UserContract.UserEntry.COLUMN_NAME_USERNAME, UserContract.UserEntry.COLUMN_NAME_SCORE)


            // How you want the results sorted in the resulting Cursor
            val sortOrder = "${UserContract.UserEntry.COLUMN_NAME_SCORE} DESC"

            val valuesDatabase = db.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
            )
          **/


            val intent = Intent(this, RankingActivity::class.java)
            startActivity(intent)
        }
    }


}