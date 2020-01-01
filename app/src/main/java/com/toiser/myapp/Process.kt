package com.toiser.myapp

import android.content.Context
import android.widget.ImageView

fun processItemSelected (context: Context, imgLift: ImageView, imgEscalator: ImageView,
                         imgStairs: ImageView, imgLine: ImageView, selectedLine: MetroLineEnum) {
    // Check if both are selected
    if (selectedDepartureStation != null && selectedArrivalStation != null
        && selectedDepartureStation != context.getString(R.string.departureStationChoicePrompt)
        && selectedArrivalStation != context.getString(R.string.ArrivalStationChoicePrompt)) {

        // Make the bouzin
        val metroLineId = when (selectedLine) {
            MetroLineEnum.A -> 1
            MetroLineEnum.B -> 3
        }

        // Display items
        displayCentralItems(imgLift, imgEscalator, imgStairs)
        // Display Metro line
        displayMetroLine(imgLine, metroLineId)
    }

}