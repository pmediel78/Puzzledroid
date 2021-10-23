package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class JuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)

        parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {
                println(1);
                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = true
                    R.id.draggableCard2 -> draggableCard2.isDragged = true
                    R.id.draggableCard3 -> draggableCard3.isDragged = true
                    R.id.draggableCard4 -> draggableCard4.isDragged = true
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                println(2);
                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = false
                    R.id.draggableCard2 -> draggableCard2.isDragged = false
                    R.id.draggableCard3 -> draggableCard3.isDragged = false
                    R.id.draggableCard4 -> draggableCard4.isDragged = false
                }
            }
        })

    }
}