package com.palabrero.app.model;

public class Leccion {
    private int id;
    private String titulo;
    private String contenido;

    public Leccion(int id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
}