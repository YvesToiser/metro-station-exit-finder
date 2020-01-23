package com.toiser.myapp

import android.widget.ImageView
import android.widget.TextView

fun displayCentralItems(imgLift: ImageView, imgEscalator: ImageView, imgStairs: ImageView) {
    imgLift.setImageResource(R.drawable.lift)
    imgEscalator.setImageResource(R.drawable.escalator)
    imgStairs.setImageResource(R.drawable.stairs)
}

fun displayMetroLine(imgLine: ImageView, metroLineId: Int) {
    when(metroLineId) {
        1 -> imgLine.setImageResource(R.drawable.line_a)
        2 -> imgLine.setImageResource(R.drawable.line_a_reverse)
        11 -> imgLine.setImageResource(R.drawable.line_b)
        12 -> imgLine.setImageResource(R.drawable.line_b_bottom)
        13 -> imgLine.setImageResource(R.drawable.line_b_reverse)
        14 -> imgLine.setImageResource(R.drawable.line_b_reverse_bottom)
        15 -> imgLine.setImageResource(R.drawable.line_b_rangueil)
    }
}

fun displayNumbers(tvLift: TextView, tvEscalator: TextView, tvStairs: TextView,
                   liftNumber: String, escalatorNumber: String, stairNumber: String) {

    tvLift.text = liftNumber
    tvEscalator.text = escalatorNumber
    tvStairs.text = stairNumber
}