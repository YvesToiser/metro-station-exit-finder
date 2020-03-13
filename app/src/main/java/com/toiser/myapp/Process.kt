package com.toiser.myapp

import android.content.Context
import android.view.View
import android.widget.*
import com.toiser.myapp.MetroStationEnum.*

fun selectMetroLine (imgLine: ImageView, layoutLift: View, layoutEscalator: View, layoutStairs: View,
                     metroLine: MetroLineEnum, btnA: ImageButton, btnB: ImageButton,
                     spinnerDeparture: Spinner, spinnerArrival: Spinner, context: Context) {

    layoutLift.visibility = View.INVISIBLE
    layoutEscalator.visibility = View.INVISIBLE
    layoutStairs.visibility = View.INVISIBLE
    imgLine.visibility = View.INVISIBLE

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
    spinnerDeparture.adapter = ArrayAdapter(context, R.layout.spinner_item, departureStationsLabelList)

    val arrivalStationsLabelList = arrayListOf<String>()
    for (i in 0 until stationNamesArrival.size) {
        arrivalStationsLabelList.add(stationNamesArrival[i].stationName)
    }
    spinnerArrival.adapter = ArrayAdapter(context, R.layout.spinner_item, arrivalStationsLabelList)
}


fun processItemSelected (textSchema: TextView, layoutLift: View, layoutEscalator: View, layoutStairs: View, tvLift: TextView,
                         tvEscalator: TextView, tvStairs: TextView, imgLift: ImageView,
                         imgEscalator: ImageView, imgStairs: ImageView, imgLine: ImageView,
                         selectedLine: MetroLineEnum) {

    // If departure & arrival are selected
    if ((selectedDepartureStation != null && selectedDepartureStation != DEPART)
        && (selectedArrivalStation != null && selectedArrivalStation != ARRIVEE)
        && (selectedDepartureStation !=  selectedArrivalStation )) {

        layoutLift.visibility = View.VISIBLE
        layoutEscalator.visibility = View.VISIBLE
        layoutStairs.visibility = View.VISIBLE
        imgLine.visibility = View.VISIBLE
        textSchema.visibility = View.VISIBLE

        //imgLine depending on departure station and way
        var metroLineId = 1
        var liftNumber = ""
        var escalatorNumber = ""
        var stairNumber = ""
        if (selectedLine == MetroLineEnum.B){
            // Check which way
            if (selectedDepartureStation!!.ordinal < selectedArrivalStation!!.ordinal) {
                // Ramonville -> Borderouge
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

                    SAOUZELONG,
                    RANGUEIL,
                    SAINT_AGNE,
                    CARMES,
                    VERDIER,
                    JEANNE_DARC,
                    BARRIERE_PARIS,
                    TROIS_COCUS,
                    BORDEROUGE,
                    CANAL_MIDI,
                    EMPALOT -> "1"

                    COMPANS -> "4"

                    UPS,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    JJB,
                    MINIMES,
                    VACHE,
                    PHARMA -> "6"

                    else -> ""
                }

                escalatorNumber = when (selectedArrivalStation) {

                    UPS,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    PHARMA -> "1"

                    JEANNE_DARC,
                    VACHE,
                    COMPANS,
                    VERDIER -> "2"

                    BARRIERE_PARIS,
                    JJB -> "4"

                    MINIMES,
                    BORDEROUGE -> "5"

                    TROIS_COCUS,
                    SAINT_AGNE,
                    RANGUEIL -> "6"

                    CARMES,
                    SAOUZELONG,
                    CANAL_MIDI,
                    EMPALOT -> ""

                    else -> ""
                }

                stairNumber = when (selectedArrivalStation) {

                    BORDEROUGE -> "1"

                    SAINT_AGNE,
                    MINIMES,
                    TROIS_COCUS,
                    RANGUEIL -> "2"

                    JJB -> "3"

                    EMPALOT -> "1 - 4"

                    CARMES -> "2 - 6"

                    CANAL_MIDI,
                    SAOUZELONG -> "4 - 6"

                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    UPS,
                    JEANNE_DARC,
                    VACHE,
                    COMPANS,
                    PHARMA -> "5"

                    BARRIERE_PARIS,
                    VERDIER -> "6"

                    else -> ""
                }

            } else if (selectedDepartureStation!!.ordinal > selectedArrivalStation!!.ordinal){
                // Borderouge -> Ramonville
                metroLineId = when (selectedDepartureStation) {

                    VACHE,
                    COMPANS,
                    CANAL_MIDI,
                    CARMES,
                    VERDIER,
                    JJB,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    UPS,
                    PHARMA,
                    SAOUZELONG,
                    TROIS_COCUS -> 13

                    BARRIERE_PARIS,
                    MINIMES,
                    JEANNE_DARC,
                    SAINT_AGNE,
                    EMPALOT,
                    RAMONVILLE,
                    BORDEROUGE -> 14

                    RANGUEIL -> 15

                    else -> 11
                }

                liftNumber = when (selectedArrivalStation) {

                    PHARMA,
                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    JJB,
                    MINIMES,
                    VACHE,
                    UPS -> "1"

                    RAMONVILLE -> "1 - 6"

                    COMPANS -> "2"

                    SAINT_AGNE,
                    SAOUZELONG,
                    EMPALOT,
                    CARMES,
                    VERDIER,
                    CANAL_MIDI,
                    BARRIERE_PARIS,
                    TROIS_COCUS,
                    JEANNE_DARC,
                    RANGUEIL -> "6"

                    else -> ""
                }

                escalatorNumber = when (selectedArrivalStation) {

                    SAINT_AGNE,
                    RANGUEIL,
                    TROIS_COCUS -> "1"

                    RAMONVILLE -> "1 - 4"

                    MINIMES -> "2"

                    JJB,
                    BARRIERE_PARIS -> "3"

                    COMPANS,
                    VERDIER,
                    JEANNE_DARC,
                    VACHE -> "5"

                    SAINT_MICHEL,
                    UPS,
                    PHARMA,
                    PALAIS_JUSTICE -> "6"

                    CARMES,
                    EMPALOT,
                    SAOUZELONG,
                    CANAL_MIDI -> "/"

                    else -> ""
                }

                stairNumber = when (selectedArrivalStation) {

                    PHARMA -> "1 - 2"
                    CANAL_MIDI,
                    SAOUZELONG -> "1 - 3"
                    RAMONVILLE -> "1 - 5"

                    BARRIERE_PARIS,
                    VERDIER -> "1"

                    SAINT_MICHEL,
                    PALAIS_JUSTICE,
                    COMPANS,
                    VACHE,
                    JEANNE_DARC,
                    UPS -> "2"

                    EMPALOT -> "3"

                    JJB -> "4"

                    SAINT_AGNE,
                    CARMES,
                    MINIMES,
                    TROIS_COCUS,
                    RANGUEIL -> "5"

                    else -> ""
                }
            }

        } else if (selectedLine == MetroLineEnum.A) {
            metroLineId = 1
            // do nothing yet
            // Check which way
            if (selectedDepartureStation!!.ordinal < selectedArrivalStation!!.ordinal) {
                // Basso -> Balma
                metroLineId = when (selectedDepartureStation) {
                    BASSO,
                    BELLEFONTAINE,
                    REYNERIE,
                    MIRAIL,
                    BAGATELLE,
                    MERMOZ,
                    FONTAINE_LESTANG,
                    ARENES,
                    PATTE_OIE,
                    SAINT_CYP,
                    MARENGO,
                    JOLIMONT,
                    ROSERAIE,
                    ARGOULETS,
                    BALMA -> 2

                    ESQUIROL,
                    CAPITOLE,
                    JJA -> 1

                    else -> 1
                }
                liftNumber = when (selectedArrivalStation) {
                    MERMOZ,
                    PATTE_OIE,
                    ROSERAIE,
                    ARGOULETS,
                    BELLEFONTAINE -> "1"

                    JJA -> "1 - 12"

                    JOLIMONT -> "2"

                    ESQUIROL -> "3"

                    MIRAIL,
                    ARENES,
                    BALMA,
                    BASSO -> "4"

                    MARENGO -> "5"

                    BAGATELLE -> "7"

                    CAPITOLE,
                    SAINT_CYP -> "8"

                    FONTAINE_LESTANG,
                    REYNERIE -> "9"

                    else -> ""
                }
                escalatorNumber = when (selectedArrivalStation) {
                    SAINT_CYP,
                    ESQUIROL,
                    CAPITOLE,
                    MARENGO,
                    ARENES -> "1"

                    BALMA -> "8"

                    PATTE_OIE -> "9"

                    JJA -> "12"

                    REYNERIE,
                    MIRAIL,
                    BAGATELLE,
                    MERMOZ,
                    FONTAINE_LESTANG,
                    BELLEFONTAINE,
                    ROSERAIE,
                    ARGOULETS,
                    JOLIMONT -> ""

                    else -> ""
                }
                stairNumber = when (selectedArrivalStation) {
                    JJA,
                    ESQUIROL -> "1"

                    ROSERAIE -> "1 - 7"

                    CAPITOLE -> "2"

                    BAGATELLE -> "2 - 7"

                    ARGOULETS -> "3 - 4"

                    BELLEFONTAINE -> "4"

                    PATTE_OIE -> "5"

                    MERMOZ -> "5 - 8"

                    MIRAIL -> "5 - 9"

                    ARENES,
                    REYNERIE -> "6 - 12"

                    MARENGO -> "7"

                    JOLIMONT -> "7 - 12"

                    SAINT_CYP -> "8"

                    BALMA -> "10"

                    FONTAINE_LESTANG -> "12"

                    else -> ""
                }
            } else if (selectedDepartureStation!!.ordinal > selectedArrivalStation!!.ordinal){
                // Balma -> Basso
                metroLineId = when (selectedDepartureStation) {
                    BELLEFONTAINE,
                    REYNERIE,
                    MIRAIL,
                    BAGATELLE,
                    MERMOZ,
                    FONTAINE_LESTANG,
                    ARENES,
                    PATTE_OIE,
                    SAINT_CYP,
                    MARENGO,
                    JOLIMONT,
                    ROSERAIE,
                    ARGOULETS,
                    BALMA -> 2

                    ESQUIROL,
                    CAPITOLE,
                    JJA -> 1

                    else -> 1
                }
                escalatorNumber = when (selectedArrivalStation) {
                    ROSERAIE,
                    MARENGO,
                    FONTAINE_LESTANG,
                    REYNERIE,
                    ARGOULETS -> ""

                    BAGATELLE,
                    JJA -> "1"

                    MIRAIL -> "3 - 8"

                    PATTE_OIE -> "4"

                    ESQUIROL,
                    BELLEFONTAINE,
                    BASSO,
                    JOLIMONT -> "6"

                    MERMOZ -> "7"

                    CAPITOLE -> "11"

                    ARENES,
                    SAINT_CYP -> "12"

                    else -> ""
                }
                stairNumber = when (selectedArrivalStation) {
                    FONTAINE_LESTANG -> "1"

                    JOLIMONT -> "1 - 6"

                    REYNERIE,
                    ARENES -> "1 - 7"

                    MERMOZ,
                    SAINT_CYP -> "5"

                    ESQUIROL -> "6"

                    BAGATELLE -> "6 - 10"

                    MARENGO -> "6 - 11"

                    ROSERAIE,
                    ARGOULETS -> "6 - 12"

                    MIRAIL -> "7"

                    PATTE_OIE -> "8"

                    BELLEFONTAINE,
                    BASSO -> "9"

                    CAPITOLE,
                    JJA -> "12"

                    else -> ""
                }
                liftNumber = when (selectedArrivalStation) {
                    JJA -> "1 - 12"

                    MIRAIL -> "3 - 8"

                    FONTAINE_LESTANG,
                    REYNERIE,
                    ESQUIROL -> "4"

                    SAINT_CYP -> "5"

                    BAGATELLE,
                    CAPITOLE -> "6"

                    MARENGO -> " 8"

                    ARENES -> "9"

                    ARGOULETS -> "9 - 10"

                    JOLIMONT -> "11"

                    PATTE_OIE,
                    BELLEFONTAINE,
                    BASSO,
                    MERMOZ,
                    ROSERAIE -> "12"

                    else -> ""
                }
            }
        }
        // Display Metro line
        displayMetroLine(imgLine, metroLineId)

        // Display items
        displayCentralItems(imgLift, imgEscalator, imgStairs)

        // Display Numbers in front of items
        displayNumbers(tvLift, tvEscalator, tvStairs, liftNumber, escalatorNumber, stairNumber)

    }
    else {
        layoutLift.visibility = View.INVISIBLE
        layoutEscalator.visibility = View.INVISIBLE
        layoutStairs.visibility = View.INVISIBLE
        imgLine.visibility = View.INVISIBLE
        textSchema.visibility = View.INVISIBLE
    }

}