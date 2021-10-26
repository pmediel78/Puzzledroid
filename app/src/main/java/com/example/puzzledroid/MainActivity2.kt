package com.example.puzzledroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.customview.widget.ViewDragHelper
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)
        parentCoordinatorLayout.addDraggableChild(draggableCard5)
        parentCoordinatorLayout.addDraggableChild(draggableCard6)
        parentCoordinatorLayout.addDraggableChild(draggableCard7)
        parentCoordinatorLayout.addDraggableChild(draggableCard8)
        parentCoordinatorLayout.addDraggableChild(draggableCard9)




        parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {

                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = true
                    R.id.draggableCard2 -> draggableCard2.isDragged = true
                    R.id.draggableCard3 -> draggableCard3.isDragged = true
                    R.id.draggableCard4 -> draggableCard4.isDragged = true
                    R.id.draggableCard5 -> draggableCard5.isDragged = true
                    R.id.draggableCard6 -> draggableCard6.isDragged = true
                    R.id.draggableCard7 -> draggableCard7.isDragged = true
                    R.id.draggableCard8 -> draggableCard8.isDragged = true
                    R.id.draggableCard9 -> draggableCard9.isDragged = true
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {

                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = false
                    R.id.draggableCard2 -> draggableCard2.isDragged = false
                    R.id.draggableCard3 -> draggableCard3.isDragged = false
                    R.id.draggableCard4 -> draggableCard4.isDragged = false
                    R.id.draggableCard5 -> draggableCard5.isDragged = false
                    R.id.draggableCard6 -> draggableCard6.isDragged = false
                    R.id.draggableCard7 -> draggableCard7.isDragged = false
                    R.id.draggableCard8 -> draggableCard8.isDragged = false
                    R.id.draggableCard9 -> draggableCard9.isDragged = false
                }
            }
        })
    }
}