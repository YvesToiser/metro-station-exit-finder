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
        if(supportActionBar != null) {
            supportActionBar?.hide()
        }

        var selectedDepartureStation = ""
        var selectedArrivalStation = ""

        // Metro stations
        val stationNamesDepartureA = arrayOf("Choisir station de départ", "Basso Cambo", "Bellefontaine", "Reynerie", "Mirail-Université", "Bagatelle", "Mermoz",
            "Fontaine Lestang", "Arènes", "Mermoz", "Patte d'Oie", "Saint Cyprien République", "Esquirol", "Capitole",
            "Jean Jaurès", "Marengo SNCF", "Jolimont", "Roseraie", "Argoulets", "Balma Grammont")

        val stationNamesDepartureB = arrayOf("Choisir station de départ", "Ramonville", "Université Paul Sabatier", "Faculté de Pharmacie", "Rangueil",
            "Saouzelong", "Saint-Agne SNCF", "Empalot", "Saint Michel Marcel Langer", "Palais de Justice", "Carmes",
            "François Verdier", "Jean Jaurès", "Jeanne d'Arc", "Compans Caffarelli", "Canal du Midi",
            "Minimes - Claude Nougaro", "Barrière de Paris", "La Vache", "Trois Cocus", "Borderouge")

        val stationNamesArrivalA = arrayOf("Choisir station d'arrivée", "Basso Cambo", "Bellefontaine", "Reynerie", "Mirail-Université", "Bagatelle", "Mermoz",
            "Fontaine Lestang", "Arènes", "Mermoz", "Patte d'Oie", "Saint Cyprien République", "Esquirol", "Capitole",
            "Jean Jaurès", "Marengo SNCF", "Jolimont", "Roseraie", "Argoulets", "Balma Grammont")

        val stationNamesArrivalB = arrayOf("Choisir station d'arrivée", "Ramonville", "Université Paul Sabatier", "Faculté de Pharmacie", "Rangueil",
            "Saouzelong", "Saint-Agne SNCF", "Empalot", "Saint Michel Marcel Langer", "Palais de Justice", "Carmes",
            "François Verdier", "Jean Jaurès", "Jeanne d'Arc", "Compans Caffarelli", "Canal du Midi",
            "Minimes - Claude Nougaro", "Barrière de Paris", "La Vache", "Trois Cocus", "Borderouge")
        // Choose Metro Line Buttons

        // get reference to button
        val btnA = findViewById<ImageButton>(R.id.A_line_button)
        val btnB = findViewById<ImageButton>(R.id.B_line_button)
        val spinnerDeparture = findViewById<Spinner>(R.id.departure_spinner)
        val spinnerArrival = findViewById<Spinner>(R.id.arrival_spinner)

        // Initial state
        var selectedLine = MetroLineEnum.A
        var stationNamesDeparture = stationNamesDepartureA
        var stationNamesArrival = stationNamesArrivalA
        btnA.isEnabled = false
        btnB.isEnabled = true

        // set on-click listeners
        btnA.setOnClickListener {
            btnA.isEnabled = false
            btnB.isEnabled = true
            selectedLine =  MetroLineEnum.A
            stationNamesDeparture = stationNamesDepartureA
            stationNamesArrival = stationNamesArrivalA
            btnA.setImageResource(R.drawable.a_active)
            btnB.setImageResource(R.drawable.b_inactive)
            spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_red)
            spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_red)
            // Spinners
            if (spinnerDeparture != null) {
                val arrayAdapterDeparture = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesDeparture)
                spinnerDeparture.adapter = arrayAdapterDeparture
            }
            if (spinnerArrival != null) {
                val arrayAdapterArrival = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesArrival)
                spinnerArrival.adapter = arrayAdapterArrival
            }
        }

        btnB.setOnClickListener {
            btnA.isEnabled = true
            btnB.isEnabled = false
            selectedLine =  MetroLineEnum.B
            stationNamesDeparture = stationNamesDepartureB
            stationNamesArrival = stationNamesArrivalB
            btnA.setImageResource(R.drawable.a_inactive)
            btnB.setImageResource(R.drawable.b_active)
            spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_yellow)
            spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_yellow)
            // Spinners
            if (spinnerDeparture != null) {
                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesDeparture)
                spinnerDeparture.adapter = arrayAdapter
            }
            if (spinnerArrival != null) {
                val arrayAdapterArrival = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesArrival)
                spinnerArrival.adapter = arrayAdapterArrival
            }
        }

        // Spinners
        if (spinnerDeparture != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesDeparture)
            spinnerDeparture.adapter = arrayAdapter

            spinnerDeparture.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedDepartureStation = stationNamesDeparture[position]
                    if (position > 0) {
                        Toast.makeText(
                            this@MainActivity,
                            "Départ : " + stationNamesDeparture[position],
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

        if (spinnerArrival != null) {
            val arrayAdapterArrival = ArrayAdapter(this, android.R.layout.simple_spinner_item, stationNamesArrival)
            spinnerArrival.adapter = arrayAdapterArrival

            spinnerArrival.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedArrivalStation = stationNamesArrival[position]
                    if (position > 0) {
                        Toast.makeText(
                            this@MainActivity,
                            "Arrivée : " + stationNamesArrival[position],
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }


    }
}
