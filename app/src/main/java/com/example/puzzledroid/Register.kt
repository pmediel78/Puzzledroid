package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth= FirebaseAuth.getInstance()
    }

    fun register(view: View){
        val email=editTextEmailAddress.editText?.text.toString()
        val password=editTextPassword.editText?.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun goToLogin(view: View){
        val intent= Intent(this,Login::class.java)
        startActivity(intent)
    }
}