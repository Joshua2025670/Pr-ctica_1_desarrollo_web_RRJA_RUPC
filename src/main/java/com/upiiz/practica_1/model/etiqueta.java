package com.upiiz.practica_1.model;

public class etiqueta {
    private String nombre;
    private String descripcion;
    private String sintaxis;
    private String atributos;
    private String ejemploCodigo;

    // Constructor para llenar los datos rápido en el Controller
    public etiqueta(String nombre, String descripcion, String sintaxis, String atributos, String ejemploCodigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sintaxis = sintaxis;
        this.atributos = atributos;
        this.ejemploCodigo = ejemploCodigo;
    }

    // Getters (Necesarios para que Thymeleaf vea los datos)
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getSintaxis() { return sintaxis; }
    public String getAtributos() { return atributos; }
    public String getEjemploCodigo() { return ejemploCodigo; }
}