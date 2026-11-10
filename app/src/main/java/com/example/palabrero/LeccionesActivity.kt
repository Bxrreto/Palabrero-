package com.example.palabrero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LeccionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecciones)

        val btnModulo1 = findViewById<Button>(R.id.btnModulo1)
        val btnModulo2 = findViewById<Button>(R.id.btnModulo2)
        btnModulo1.setOnClickListener {
            val intent = Intent(this, DetalleLeccionActivity::class.java).apply {
                putExtra("EXTRA_ID_MODULO", 1) // ID 1 para el Módulo 1 en SQLite
            }
            startActivity(intent)
        }

        btnModulo2.setOnClickListener {
            val intent = Intent(this, DetalleLeccionActivity::class.java).apply {
                putExtra("EXTRA_ID_MODULO", 2) // ID 2 para el Módulo 2 en SQLite
            }
            startActivity(intent)
        }
    }
}