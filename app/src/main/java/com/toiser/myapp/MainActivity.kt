package com.toiser.myapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Choose Metro Line Buttons

        // get reference to button
        val btnA = findViewById<ImageButton>(R.id.A_line_button)
        val btnB = findViewById<ImageButton>(R.id.B_line_button)
        val spinnerDeparture = findViewById<Spinner>(R.id.departure_spinner)
        val spinnerArrival = findViewById<Spinner>(R.id.arrival_spinner)

        // Initial state
        var selectedLine = MetroLineEnum.A
        btnA.isEnabled = false
        btnB.isEnabled = true

        // set on-click listeners
        if (btnA.isEnabled) {
            btnA.setOnClickListener {
                btnA.isEnabled = false
                btnB.isEnabled = true
                selectedLine =  MetroLineEnum.A
                btnA.setImageResource(R.drawable.a_active)
                btnB.setImageResource(R.drawable.b_inactive)
                spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_red)
                spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_red)
            }
        }

        if (btnB.isEnabled) {
            btnB.setOnClickListener {
                btnA.isEnabled = true
                btnB.isEnabled = false
                selectedLine =  MetroLineEnum.B
                btnA.setImageResource(R.drawable.a_inactive)
                btnB.setImageResource(R.drawable.b_active)
                spinnerDeparture.setBackgroundResource(R.drawable.spinner_bar_yellow)
                spinnerArrival.setBackgroundResource(R.drawable.spinner_bar_yellow)
            }
        }

    }
}
