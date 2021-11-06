package com.example.puzzledroid

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout

import android.graphics.BitmapFactory
import kotlinx.android.synthetic.main.activity2_juego.*
import android.widget.TextView
import kotlin.text.toInt as toInt1

class Juego2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_juego)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)
        parentCoordinatorLayout.addDraggableChild(draggableCard5)
        parentCoordinatorLayout.addDraggableChild(draggableCard6)
        parentCoordinatorLayout.addDraggableChild(draggableCard7)
        parentCoordinatorLayout.addDraggableChild(draggableCard8)
        parentCoordinatorLayout.addDraggableChild(draggableCard9)

        val bm = GetRandomImage()

        val imageCropper = ImageCropper()
        val imagecropped = imageCropper.splitBitmap(bm,3,3,9)



        image1.setImageBitmap(imagecropped?.get(0))
        image2.setImageBitmap(imagecropped?.get(3))
        image3.setImageBitmap(imagecropped?.get(6))
        image4.setImageBitmap(imagecropped?.get(1))
        image5.setImageBitmap(imagecropped?.get(4))
        image6.setImageBitmap(imagecropped?.get(7))
        image7.setImageBitmap(imagecropped?.get(2))
        image8.setImageBitmap(imagecropped?.get(5))
        image9.setImageBitmap(imagecropped?.get(8))


        val Contador_1= intent.getStringExtra("Counter")?.toInt1()
        var Counter = Contador_1
        val Contador: TextView = findViewById(R.id.Counter)
        Contador.text=Counter.toString()


        if (Counter != null) {
            parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
                override fun onViewCaptured(view: View, i: Int) {
                }

                override fun onViewReleased(view: View, v: Float, v1: Float) {
                    val helper = Helper()
                    Counter += 1
                    val win= helper.resolve(view, parentCoordinatorLayout, resources,Counter)
                    val Contador: TextView = findViewById(R.id.Counter)
                    Contador.text=Counter.toString()
                    if(win){
                        val intent = Intent(this@Juego2Activity,Juego3Activity::class.java);
                        intent.putExtra("Counter", Counter.toString())
                        startActivity(intent);
                        finish();
                    }
                }
            })
        }

    }

    private fun GetRandomImage() : Bitmap {
        val photoList = listOf(
            R.drawable.imagerandom2,
            R.drawable.dragonball,
            R.drawable.imagerandom,
            R.drawable.arbol1,
            R.drawable.bosque1,
            R.drawable.buho,
            R.drawable.ciervo,
            R.drawable.fotohojas,
            R.drawable.isla,
            R.drawable.bosque2,
            R.drawable.sunset2,
            R.drawable.mariposa,
            R.drawable.mountais,
            R.drawable.night1,
            R.drawable.cosarara,
            R.drawable.arbol2,
            R.drawable.barco,
            R.drawable.casa,
            R.drawable.casabosque,
            R.drawable.catsillo1,
            R.drawable.metro,
            R.drawable.mountain2,
            R.drawable.rio,
            R.drawable.sanfrancisco
        )
        val randomNumber = (0..(photoList.count()-1)).random()
        val bm = BitmapFactory.decodeResource(resources, photoList[randomNumber])
        return bm
    }
}