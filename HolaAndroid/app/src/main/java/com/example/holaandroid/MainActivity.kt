package com.example.holaandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val textMessage: TextView = findViewById(R.id.textMessage)
        val btnChangeMessage: Button = findViewById(R.id.btnChangeMessage)

        // Listener del botón: cambia el texto al presionarlo
        btnChangeMessage.setOnClickListener {
            textMessage.text = "¡Botón presionado!"
        }
    }
}
