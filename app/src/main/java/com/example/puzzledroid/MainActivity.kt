package com.example.puzzledroid


import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.create
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ramijemli.easings.Easings
import com.ramijemli.easings.Interpolators
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @BindView(R.id.Juegobtn) lateinit var juegoBTN: Button
    @BindView(R.id.Rankingbtn) lateinit var rankingBTN: Button
    @BindView(R.id.Ayudabtn) lateinit var ayudaBTN: Button
    @BindView(R.id.JuegoFromPhotobtn) lateinit var juegoFromPhotoBTN: Button
    @BindView(R.id.Galeriabtn) lateinit var galeriaBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        StartAnimations()

    }

    private fun StartAnimations() {
        val juegoBtn: Button = findViewById(R.id.Juegobtn)
        ButtonAnimation(juegoBtn,300L)

        val Rankingbtn: Button = findViewById(R.id.Rankingbtn)
        ButtonAnimation(Rankingbtn,450L)

        val Ayudabtn: Button = findViewById(R.id.Ayudabtn)
        ButtonAnimation(Ayudabtn,600L)

        val JuegoFromPhotobtn: Button = findViewById(R.id.JuegoFromPhotobtn)
        ButtonAnimation(JuegoFromPhotobtn,750L)

        val Galeriabtn: Button = findViewById(R.id.Galeriabtn)
        ButtonAnimation(Galeriabtn,900L)
        val context = this
        val player = MediaPlayer.create(this, R.raw.musicafondo)

        player.isLooping=true
        player.start()
        btnplay.setBackgroundResource(R.drawable.audio)
        btnplay.setOnClickListener{
            if(player.isPlaying){
                player.pause()
                btnplay.setBackgroundResource(R.drawable.mute)
                Toast.makeText(context, "Silencio", LENGTH_SHORT).show()
            }
            else{
                player.start()
                btnplay.setBackgroundResource(R.drawable.audio)
                Toast.makeText(context, "Sonido Activado", LENGTH_SHORT).show()
            }
        }
    }

    private fun ButtonAnimation(button: Button,delay: Long) {
        button.animate().apply {
            startDelay = delay
            duration = 3000
            translationX(280F)
            interpolator = Interpolators(Easings.ELASTIC_OUT)
            start()
        }
    }

    private fun Title(textView: TextView,delay: Long) {
        textView.animate().apply {
            startDelay = delay
            duration = 3000
            scaleXBy(3F)
            interpolator = Interpolators(Easings.ELASTIC_OUT)
            start()
        }
    }





    @OnClick(R.id.Juegobtn)
    fun  JuegoClick() {
       val intent = Intent(this, JuegoActivity::class.java)
       startActivity(intent)
    }

    @OnClick(R.id.Rankingbtn)
    fun  RankingClick() {
        val intent = Intent(this, RankingActivity::class.java)
        startActivity(intent)
    }

    @OnClick(R.id.Ayudabtn)
    fun  AyudaButtonClick() {
        val intent = Intent(this, AyudaActivity::class.java)
        startActivity(intent)
    }

    @OnClick(R.id.JuegoFromPhotobtn)
    fun  JuegoFromPhotoButtonClick() {
        val intent = Intent(this, JuegoFromPhoto::class.java)
        startActivity(intent)
    }

    //With ButterKnife
    @OnClick(R.id.Galeriabtn)
    fun  GaleriaButtonClick() {
        val intent = Intent(this, JuegofromGallery::class.java)
        startActivity(intent)
    }

    //Without ButterKnife
    /*private fun GaleriaButtonClick() {
        val galeriaBtn: Button = findViewById(R.id.Galeriabtn)
        galeriaBtn.setOnClickListener {
            val intent = Intent(this, JuegofromGallery::class.java)
            startActivity(intent)
        }
    }*/




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