package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout

import android.graphics.BitmapFactory
import kotlinx.android.synthetic.main.activity_juego.*
import android.widget.TextView


class JuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)

        val bm = BitmapFactory.decodeResource(resources, R.drawable.imagerandom2)

        val imageCropper = ImageCropper()
        val imagecropped = imageCropper.splitBitmap(bm,2,2,4)



        image1.setImageBitmap(imagecropped?.get(0))
        image2.setImageBitmap(imagecropped?.get(2))
        image3.setImageBitmap(imagecropped?.get(1))
        image4.setImageBitmap(imagecropped?.get(3))



        var Counter =0
        parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                val helper = Helper()

                Counter += 1
                val win=helper.resolve(view, parentCoordinatorLayout, resources,Counter)
                val Contador: TextView = findViewById(R.id.Counter)
                Contador.text=Counter.toString()
                if(win){
                    val intent = Intent(this@JuegoActivity,Juego2Activity::class.java);
                    intent.putExtra("Counter", Counter.toString())
                    startActivity(intent);
                }

            }
        })

    }

}