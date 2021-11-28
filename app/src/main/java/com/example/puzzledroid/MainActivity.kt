package com.example.puzzledroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println(0);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetButtonOnClickListeners();
    }

    fun SetButtonOnClickListeners() {
        RankingButtonClick()
        JuegoButtonClick()
        AyudaButtonClick()
        JuegoFromPhotoButtonClick()
        GaleriaButtonClick()
    }

    private fun JuegoButtonClick() {
        val juegoBtn: Button = findViewById(R.id.Juegobtn)
        juegoBtn.setOnClickListener {
            val intent = Intent(this, JuegoActivity::class.java)
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

    private fun JuegoFromPhotoButtonClick() {
        val juegoFromPhotoBtn: Button = findViewById(R.id.JuegoFromPhotobtn)
        juegoFromPhotoBtn.setOnClickListener {
            val intent = Intent(this, JuegoFromPhoto::class.java)
            startActivity(intent)
        }
    }

    private fun GaleriaButtonClick() {
        val galeriaBtn: Button = findViewById(R.id.Galeriabtn)
        galeriaBtn.setOnClickListener {
            cargarGaleria();
        }
    }

    private fun cargarGaleria() {
        println("galeria")
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when {
            requestCode == 1 && resultCode == Activity.RESULT_OK -> {
                var imageUri = data!!.data
                println(imageUri)
            }
        }
    }

}