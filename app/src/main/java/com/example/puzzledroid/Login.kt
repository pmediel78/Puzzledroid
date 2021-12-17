package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth= FirebaseAuth.getInstance()


    }

    fun login(view: View){
        val email=editTextEmailAddress.editText?.text.toString()
        val password=editTextPassword.editText?.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    fun goToRegister(view: View){
        val intent= Intent(this,Register::class.java)
        startActivity(intent)
    }

}