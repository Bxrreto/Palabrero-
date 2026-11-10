package com.example.palabrero

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.palabrero.app.data.DatabaseHelper

class DetalleLeccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_leccion)

        val txtTitulo = findViewById<TextView>(R.id.txtTituloDetalle)
        val txtContenido = findViewById<TextView>(R.id.txtContenidoDetalle)

        // Recibimos el ID del módulo que se presionó (1 o 2)
        val idModulo = intent.getIntExtra("EXTRA_ID_MODULO", 1)

        // Consultamos directamente a SQLite usando el DatabaseHelper
        val dbHelper = DatabaseHelper(this)
        val cursor = dbHelper.obtenerLeccionPorId(idModulo)

        if (cursor != null && cursor.moveToFirst()) {
            val tituloIndex = cursor.getColumnIndex("titulo")
            val contenidoIndex = cursor.getColumnIndex("contenido")

            val titulo = if (tituloIndex != -1) cursor.getString(tituloIndex) else "Lección"
            val contenido = if (contenidoIndex != -1) cursor.getString(contenidoIndex) else "Sin contenido"

            txtTitulo.text = titulo
            txtContenido.text = contenido
            cursor.close()
        } else {
            txtTitulo.text = "Error"
            txtContenido.text = "No se pudo recuperar la información de la base de datos local."
        }
    }
}