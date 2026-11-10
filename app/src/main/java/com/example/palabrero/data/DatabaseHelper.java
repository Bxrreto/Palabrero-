package com.palabrero.app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.palabrero.R; // Asegúrate de que coincida con tu paquete si es necesario

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "palabrero.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla lecciones
        db.execSQL("CREATE TABLE lecciones (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, contenido TEXT, nivel TEXT)");

        // Insertar datos iniciales por defecto para que la app tenga contenido offline
        insertarLeccionInicial(db, "Módulo 1: Vocales y Sonidos", "Las vocales son los sonidos a, e, i, o, u que forman la base de la lectura offline en Palabrero. Este texto se consulta directamente de la base de datos SQLite interna del dispositivo.", "Básico");
        insertarLeccionInicial(db, "Módulo 2: Consonantes Básicas", "Las consonantes como m, p, s, l se combinan con las vocales para formar sílabas directas. Datos almacenados localmente sin requerir conexión a la red.", "Básico");
    }

    private void insertarLeccionInicial(SQLiteDatabase db, String titulo, String contenido, String nivel) {
        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("contenido", contenido);
        values.put("nivel", nivel);
        db.insert("lecciones", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS lecciones");
        onCreate(db);
    }

    // Método para consultar una lección específica por su ID o posición
    public Cursor obtenerLeccionPorId(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT titulo, contenido FROM lecciones WHERE id = ?", new String[]{String.valueOf(id)});
    }
}