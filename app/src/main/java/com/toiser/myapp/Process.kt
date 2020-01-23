package com.toiser.myapp

import android.content.Context
import android.widget.*
import com.toiser.myapp.MetroStationEnum.*

fun selectMetroLine (metroLine: MetroLineEnum, btnA: ImageButton, btnB: ImageButton,
                     spinnerDeparture: Spinner, spinnerArrival: Spinner, context: Context) {
    if (metroLine == MetroLineEnum.A) {
        selectedLine = MetroLineEnum.A
        stationNamesDeparture = stationNamesDepartureA
        stationNamesArrival = stationNamesArrivalA
        btnA.isEnabled = false
        btnB.isEnabled = true
        btnA.setImageResource(R.drawable.a_active)
        btnB.setImageResource(R.drawable.b_inactive)
        spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_red)
        spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_red)
    } else if (metroLine == MetroLineEnum.B) {
        selectedLine = MetroLineEnum.B
        stationNamesDeparture = stationNamesDepartureB
        stationNamesArrival = stationNamesArrivalB
        btnA.isEnabled = true
        btnB.isEnabled = false
        btnA.setImageResource(R.drawable.a_inactive)
        btnB.setImageResource(R.drawable.b_active)
        spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_yellow)
        spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_yellow)
    }

    val departureStationsLabelList = arrayListOf<String>()
    for (i in 0 until stationNamesDeparture.size) {
        departureStationsLabelList.add(stationNamesDeparture[i].stationName)
    }
    spinnerDeparture.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, departureStationsLabelList)

    val arrivalStationsLabelList = arrayListOf<String>()
    for (i in 0 until stationNamesArrival.size) {
        arrivalStationsLabelList.add(stationNamesArrival[i].stationName)
    }
    spinnerArrival.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, arrivalStationsLabelList)
}


fun processItemSelected (tvLift: TextView, tvEscalator: TextView, tvStairs: TextView,
                         imgLift: ImageView, imgEscalator: ImageView, imgStairs: ImageView,
                         imgLine: ImageView, selectedLine: MetroLineEnum) {

    // If departure & arrival are selected
    if ((selectedDepartureStation != null && selectedDepartureStation != DEPART)
        && (selectedArrivalStation != null && selectedArrivalStation != ARRIVEE)) {

        //imgLine depending on departure station and way
        var metroLineId = 1
        var liftNumber = ""
        var escalatorNumber = ""
        var stairNumber = ""
        if (selectedLine == MetroLineEnum.B){
            // Check which way
            if (selectedDepartureStation!!.ordinal < selectedArrivalStation!!.ordinal) {
                metroLineId = when (selectedDepartureStation) {

                    SAINT_AGNE,
                    EMPALOT -> 13

                    RAMONVILLE,
                    UPS,
                    PHARMA,
                    SAOUZELONG,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    CARMES,
                    VERDIER,
                    JJB,
                    JEANNE_DARC,
                    COMPANS,
                    CANAL_MIDI,
                    MINIMES,
                    BARRIERE_PARIS,
                    VACHE,
                    TROIS_COCUS -> 14

                    RANGUEIL -> 15

                    else -> 11
                }

                liftNumber = when (selectedArrivalStation) {

                    UPS,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    JJB,
                    PHARMA -> "6"

                    SAOUZELONG,
                    RANGUEIL,
                    SAINT_AGNE,
                    CARMES,
                    VERDIER,
                    JEANNE_DARC,
                    EMPALOT -> "1"

                    // TODO Matt
                    COMPANS,
                    CANAL_MIDI,
                    MINIMES,
                    BARRIERE_PARIS,
                    VACHE,
                    TROIS_COCUS,
                    BORDEROUGE -> ""
                    else -> ""
                }

                escalatorNumber = when (selectedArrivalStation) {

                    UPS,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    PHARMA -> "1"

                    SAINT_AGNE,
                    RANGUEIL -> "6"

                    JEANNE_DARC,
                    VERDIER -> "2"

                    JJB -> "4"

                    CARMES,
                    SAOUZELONG,
                    EMPALOT -> "/"


                    // TODO Matt
                    COMPANS,
                    CANAL_MIDI,
                    MINIMES,
                    BARRIERE_PARIS,
                    VACHE,
                    TROIS_COCUS,
                    BORDEROUGE -> ""
                    else -> ""
                }

                stairNumber = when (selectedArrivalStation) {

                    SAINT_AGNE,
                    RANGUEIL -> "2"

                    JJB -> "3"

                    EMPALOT -> "1 - 4"
                    CARMES -> "2 - 6"
                    SAOUZELONG -> "4 - 6"

                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    UPS,
                    JEANNE_DARC,
                    PHARMA -> "5"

                    VERDIER -> "6"

                    // TODO Matt
                    COMPANS,
                    CANAL_MIDI,
                    MINIMES,
                    BARRIERE_PARIS,
                    VACHE,
                    TROIS_COCUS,
                    BORDEROUGE -> ""
                    else -> ""
                }

            } else if (selectedDepartureStation!!.ordinal > selectedArrivalStation!!.ordinal){
                metroLineId = 11
            } else {
                // Do nothing
            }

        } else if (selectedLine == MetroLineEnum.A) {
            metroLineId = 1
            // do nothing yet
            // Check which way
            if (selectedDepartureStation!!.ordinal < selectedArrivalStation!!.ordinal) {
                // Do nothing
            } else if (selectedDepartureStation!!.ordinal > selectedArrivalStation!!.ordinal){
                // Do nothing
            } else {
                // Do nothing
            }
        }
        // Display Metro line
        displayMetroLine(imgLine, metroLineId)

        // Display items
        displayCentralItems(imgLift, imgEscalator, imgStairs)

        // Display Numbers in front of items
        displayNumbers(tvLift, tvEscalator, tvStairs, liftNumber, escalatorNumber, stairNumber)

    }

}