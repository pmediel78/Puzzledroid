package com.example.puzzledroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout

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
                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = false
                    R.id.draggableCard2 -> draggableCard2.isDragged = false
                    R.id.draggableCard3 -> draggableCard3.isDragged = false
                    R.id.draggableCard4 -> draggableCard4.isDragged = false
                }

                var x : Float = 0f
                var y : Float = 0f

                if (view.getTag() == "card1") {
                    println(1)
                    x = fondo1.x
                    y = fondo1.y
                }
                if (view.getTag() == "card2") {
                    println(2)
                    x = fondo2.x
                    y = fondo2.y
                }
                if (view.getTag() == "card3") {
                    println(3)
                    x = fondo3.x
                    y = fondo3.y
                }
                if (view.getTag() == "card4") {
                    println(4)
                    x = fondo4.x
                    y = fondo4.y
                }

                if(x - 100 < view.x && x + 100 > view.x && y - 100 < view.y && y + 100 > view.y){
                    view.x = x
                    view.y = y
                }

                if (draggableCard1.x == fondo1.x &&
                    draggableCard2.x == fondo2.x &&
                    draggableCard3.x == fondo3.x &&
                    draggableCard4.x == fondo4.x ) {
                    println("GANA")
                }
            }
        })
    }
}