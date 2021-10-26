package com.example.puzzledroid

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout
import android.graphics.Bitmap

import android.graphics.BitmapFactory
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_juego.*
import android.graphics.RectF


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




        parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                val helper = Helper()
                helper.resolve(view, parentCoordinatorLayout, resources)

            }
        })
    }

}