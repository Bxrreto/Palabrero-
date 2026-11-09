package com.palabrero.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.palabrero.app.R; // Asegúrate de importar tu paquete de recursos

public class MainActivity extends Activity {

    private Button btnLecciones, btnAsistenteIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLecciones = findViewById(R.id.btnLecciones);
        btnAsistenteIA = findViewById(R.id.btnAsistenteIA);

        // Acción botón lecciones offline (SQLite)
        btnLecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Abriendo modo offline (SQLite)", Toast.LENGTH_SHORT).show();
                // Aquí se abrirá la actividad de lecciones locales
            }
        });

        // Acción botón ejercicios online (API OpenAI)
        btnAsistenteIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Conectando con el asistente de IA...", Toast.LENGTH_SHORT).show();
                // Aquí se conectará con ApiClient.java
            }
        });
    }
}