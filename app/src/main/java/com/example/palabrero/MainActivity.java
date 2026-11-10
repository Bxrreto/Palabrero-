package com.example.palabrero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLecciones, btnAsistenteIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLecciones = findViewById(R.id.btnLecciones);
        btnAsistenteIA = findViewById(R.id.btnAsistenteIA);

        // Acción botón lecciones offline [SQLite]
        btnLecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la pantalla de lecciones offline
                Intent intent = new Intent(MainActivity.this, LeccionesActivity.class);
                startActivity(intent);
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