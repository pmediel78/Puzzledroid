package com.example.puzzledroid

import android.view.View
import android.view.ViewGroup
import com.google.android.material.card.MaterialCardView

class Helper {

    fun resolve(view: View, parent: ViewGroup, resources: android.content.res.Resources ) {
        var x: Float = 0f
        var y: Float = 0f
        var dist = 100
        var win = true

        var name = resources.getResourceEntryName(view.id)
        var position = parent.findViewWithTag<MaterialCardView>(name)

        x = position.x
        y = position.y

        if (x - dist < view.x && x + dist > view.x && y - dist < view.y && y + dist > view.y) {
            view.x = x
            view.y = y
        }

        val outputViews = getViewsByTag(parent, "card")

        if (outputViews != null) {
            for (outputView in outputViews) {
                name = resources.getResourceEntryName(outputView.id)
                position = parent.findViewWithTag<MaterialCardView>(name)
                if (outputView.x !== position.x)
                    win = false
            }
        }

        if (win) {
            println("GANA")
        }
    }

    private fun getViewsByTag(root: ViewGroup, tag: String): ArrayList<View>? {
        val views = ArrayList<View>()
        val childCount = root.childCount
        for (i in 0 until childCount) {
            val child = root.getChildAt(i)
            if (child is ViewGroup) {
                views.addAll(getViewsByTag(child, tag)!!)
            }
            val tagObj = child.tag
            if (tagObj != null && tagObj == tag) {
                views.add(child)
            }
        }
        return views
    }
}