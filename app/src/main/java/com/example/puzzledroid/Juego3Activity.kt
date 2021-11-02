package com.example.puzzledroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.draggableCard5
import kotlinx.android.synthetic.main.activity_main2.draggableCard6
import kotlinx.android.synthetic.main.activity_main2.draggableCard7
import kotlinx.android.synthetic.main.activity_main2.draggableCard8
import kotlinx.android.synthetic.main.activity_main2.draggableCard9
import kotlinx.android.synthetic.main.activity_main2.draggableCard10
import kotlinx.android.synthetic.main.activity_main2.draggableCard11
import kotlinx.android.synthetic.main.activity_main2.draggableCard12
import kotlinx.android.synthetic.main.activity_main2.draggableCard13
import kotlinx.android.synthetic.main.activity_main2.draggableCard14
import kotlinx.android.synthetic.main.activity_main2.draggableCard15
import kotlinx.android.synthetic.main.activity_main2.draggableCard16
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout

import android.graphics.BitmapFactory

import android.widget.TextView

import kotlinx.android.synthetic.main.activity3_juego.*

class Juego3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3_juego)

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
        parentCoordinatorLayout.addDraggableChild(draggableCard10)
        parentCoordinatorLayout.addDraggableChild(draggableCard11)
        parentCoordinatorLayout.addDraggableChild(draggableCard12)
        parentCoordinatorLayout.addDraggableChild(draggableCard13)
        parentCoordinatorLayout.addDraggableChild(draggableCard14)
        parentCoordinatorLayout.addDraggableChild(draggableCard15)
        parentCoordinatorLayout.addDraggableChild(draggableCard16)

        val bm = BitmapFactory.decodeResource(resources, R.drawable.spidi)

        val imageCropper = ImageCropper()
        val imagecropped = imageCropper.splitBitmap(bm,4,4,16)



        image1.setImageBitmap(imagecropped?.get(0))
        image2.setImageBitmap(imagecropped?.get(14))
        image3.setImageBitmap(imagecropped?.get(10))
        image4.setImageBitmap(imagecropped?.get(8))
        image5.setImageBitmap(imagecropped?.get(4))
        image6.setImageBitmap(imagecropped?.get(12))
        image7.setImageBitmap(imagecropped?.get(9))
        image8.setImageBitmap(imagecropped?.get(11))
        image9.setImageBitmap(imagecropped?.get(3))
        image10.setImageBitmap(imagecropped?.get(6))
        image11.setImageBitmap(imagecropped?.get(2))
        image12.setImageBitmap(imagecropped?.get(7))
        image13.setImageBitmap(imagecropped?.get(5))
        image14.setImageBitmap(imagecropped?.get(13))
        image15.setImageBitmap(imagecropped?.get(1))
        image16.setImageBitmap(imagecropped?.get(15))



        val Contador_1= intent.getStringExtra("Counter")?.toInt()
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
                    helper.resolve(view, parentCoordinatorLayout, resources,Counter)
                    val Contador: TextView = findViewById(R.id.Counter)
                    Contador.text=Counter.toString()
                }
            })
        }
    }
}