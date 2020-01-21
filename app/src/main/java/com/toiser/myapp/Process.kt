package com.toiser.myapp

import android.content.Context
import android.widget.*

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
    spinnerDeparture.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, stationNamesDeparture)
    spinnerArrival.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, stationNamesArrival)
}


fun processItemSelected (tvLift: TextView, tvEscalator: TextView, tvStairs: TextView,
                         imgLift: ImageView, imgEscalator: ImageView, imgStairs: ImageView,
                         imgLine: ImageView, selectedLine: MetroLineEnum) {

    // If departure & arrival are selected
    if ((selectedDepartureStation != null && selectedDepartureStation != MetroStationEnum.DEPART)
        && (selectedArrivalStation != null && selectedArrivalStation != MetroStationEnum.ARRIVEE)) {

        //imgLine depending on departure station and way
        var metroLineId = 1
        var liftNumber = 0
        var escalatorNumber = 0
        var stairNumber = 0
        if (selectedLine == MetroLineEnum.B){
            // Check which way
            if (selectedDepartureStation!!.ordinal < selectedArrivalStation!!.ordinal) {
                metroLineId = when (selectedDepartureStation) {

                    MetroStationEnum.SAINT_AGNE,
                    MetroStationEnum.EMPALOT -> 13

                    MetroStationEnum.RAMONVILLE,
                    MetroStationEnum.UPS,
                    MetroStationEnum.PHARMA,
                    MetroStationEnum.SAOUZELONG,
                    MetroStationEnum.SAINT_MICHEL,
                    MetroStationEnum.PALAIS_JUSTICE,
                    MetroStationEnum.CARMES,
                    MetroStationEnum.VERDIER,
                    MetroStationEnum.JJB,
                    MetroStationEnum.JEANNE_DARC,
                    MetroStationEnum.COMPANS,
                    MetroStationEnum.CANAL_MIDI,
                    MetroStationEnum.MINIMES,
                    MetroStationEnum.BARRIERE_PARIS,
                    MetroStationEnum.VACHE,
                    MetroStationEnum.TROIS_COCUS -> 14

                    MetroStationEnum.RANGUEIL -> 15

                    else -> 11
                }

                liftNumber = when (selectedArrivalStation) {

                    MetroStationEnum.UPS,
                    MetroStationEnum.SAINT_MICHEL,
                    MetroStationEnum.PALAIS_JUSTICE,
                    MetroStationEnum.JJB,
                    MetroStationEnum.PHARMA -> 6

                    MetroStationEnum.SAOUZELONG,
                    MetroStationEnum.RANGUEIL,
                    MetroStationEnum.SAINT_AGNE,
                    MetroStationEnum.CARMES,
                    MetroStationEnum.VERDIER,
                    MetroStationEnum.JEANNE_DARC,
                    MetroStationEnum.EMPALOT-> 1

                    // Not yet implemented TODO Matt
                    MetroStationEnum.COMPANS,
                    MetroStationEnum.CANAL_MIDI,
                    MetroStationEnum.MINIMES,
                    MetroStationEnum.BARRIERE_PARIS,
                    MetroStationEnum.VACHE,
                    MetroStationEnum.TROIS_COCUS,
                    MetroStationEnum.BORDEROUGE -> 0
                    else -> 0
                }

                escalatorNumber = when (selectedArrivalStation) {

                    MetroStationEnum.UPS,
                    MetroStationEnum.SAINT_MICHEL,
                    MetroStationEnum.PALAIS_JUSTICE,
                    MetroStationEnum.PHARMA -> 1

                    MetroStationEnum.SAINT_AGNE,
                    MetroStationEnum.RANGUEIL -> 6

                    MetroStationEnum.JEANNE_DARC,
                    MetroStationEnum.VERDIER -> 2

                    MetroStationEnum.JJB -> 4

                    MetroStationEnum.CARMES,
                    MetroStationEnum.SAOUZELONG,
                    MetroStationEnum.EMPALOT-> 0


                    // Not yet implemented TODO Matt
                    MetroStationEnum.COMPANS,
                    MetroStationEnum.CANAL_MIDI,
                    MetroStationEnum.MINIMES,
                    MetroStationEnum.BARRIERE_PARIS,
                    MetroStationEnum.VACHE,
                    MetroStationEnum.TROIS_COCUS,
                    MetroStationEnum.BORDEROUGE -> 0
                    else -> 0
                }

                stairNumber = when (selectedArrivalStation) {

                    MetroStationEnum.SAINT_AGNE,
                    MetroStationEnum.RANGUEIL -> 2

                    MetroStationEnum.JJB -> 3

                    MetroStationEnum.EMPALOT,
                    MetroStationEnum.SAOUZELONG -> 4

                    MetroStationEnum.SAINT_MICHEL,
                    MetroStationEnum.PALAIS_JUSTICE,
                    MetroStationEnum.UPS,
                    MetroStationEnum.JEANNE_DARC,
                    MetroStationEnum.PHARMA -> 5

                    MetroStationEnum.CARMES,
                    MetroStationEnum.VERDIER -> 6


                    //TODO saouzelong 4 ou 6 !!! Empalot 4 ou 1 Carmes 2 ou 6

                    // Not yet implemented TODO Matt
                    MetroStationEnum.COMPANS,
                    MetroStationEnum.CANAL_MIDI,
                    MetroStationEnum.MINIMES,
                    MetroStationEnum.BARRIERE_PARIS,
                    MetroStationEnum.VACHE,
                    MetroStationEnum.TROIS_COCUS,
                    MetroStationEnum.BORDEROUGE -> 0
                    else -> 0
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