package com.example.puzzledroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_juego.*
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
                var x: Float = 0f
                var y: Float = 0f
                var dist = 100


                var name = resources.getResourceEntryName(view.id)
                var position = parentCoordinatorLayout.findViewWithTag<MaterialCardView>(name)

                x = position.x
                y = position.y

                if (x - dist < view.x && x + dist > view.x && y - dist < view.y && y + dist > view.y) {
                    view.x = x
                    view.y = y
                }

                if (draggableCard1.x == fondo1.x &&
                    draggableCard2.x == fondo2.x &&
                    draggableCard3.x == fondo3.x &&
                    draggableCard4.x == fondo4.x
                ) {
                    println("GANA")
                }
            }
        })
    }
}