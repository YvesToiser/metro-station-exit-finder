package com.toiser.myapp

import android.widget.ImageView

fun displayCentralItems(imgLift: ImageView, imgEscalator: ImageView, imgStairs: ImageView) {
    imgLift.setImageResource(R.drawable.lift)
    imgEscalator.setImageResource(R.drawable.escalator)
    imgStairs.setImageResource(R.drawable.stairs)
}

fun displayMetroLine(imgLine: ImageView, metroLineId: Int) {
    when(metroLineId) {
        1 -> imgLine.setImageResource(R.drawable.line_a)
        2 -> imgLine.setImageResource(R.drawable.line_a_reverse)
        3 -> imgLine.setImageResource(R.drawable.line_b)
        4 -> imgLine.setImageResource(R.drawable.line_b_bottom)
        5 -> imgLine.setImageResource(R.drawable.line_b_reverse)
        6 -> imgLine.setImageResource(R.drawable.line_b_reverse_bottom)
    }
}