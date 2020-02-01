package com.toiser.myapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Title Bar
        hideActionBar(supportActionBar)

        // get reference to button
        val btnA = findViewById<ImageButton>(R.id.A_line_button)
        val btnB = findViewById<ImageButton>(R.id.B_line_button)
        val spinnerDeparture = findViewById<Spinner>(R.id.departure_spinner)
        val spinnerArrival = findViewById<Spinner>(R.id.arrival_spinner)
        val imgLift = findViewById<ImageView>(R.id.imageViewLift)
        val imgEscalator = findViewById<ImageView>(R.id.imageViewEscalator)
        val imgStairs = findViewById<ImageView>(R.id.imageViewStairs)
        val imgLine = findViewById<ImageView>(R.id.imageViewLine)
        val tvLift = findViewById<TextView>(R.id.tvLiftNumber)
        val tvEscalator = findViewById<TextView>(R.id.tvEscalatorNumber)
        val tvStairs = findViewById<TextView>(R.id.tvStairsNumber)

        // Initial state
        selectMetroLine(MetroLineEnum.A, btnA, btnB, spinnerDeparture, spinnerArrival, this)

        // set on-click listeners
        btnA.setOnClickListener {
            selectMetroLine(MetroLineEnum.A, btnA, btnB, spinnerDeparture, spinnerArrival, this)
        }

        btnB.setOnClickListener {
            selectMetroLine(MetroLineEnum.B, btnA, btnB, spinnerDeparture, spinnerArrival, this)
        }

        spinnerDeparture.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedDepartureStation = stationNamesDeparture[position]
                if (position > 0) {
                    processItemSelected( tvLift, tvEscalator, tvStairs, imgLift, imgEscalator, imgStairs,
                        imgLine, selectedLine)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }

        spinnerArrival.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedArrivalStation = stationNamesArrival[position]
                if (position > 0) {
                    processItemSelected( tvLift, tvEscalator, tvStairs, imgLift, imgEscalator, imgStairs,
                        imgLine, selectedLine)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }
    }
}
