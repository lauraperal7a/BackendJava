package org.example;

import java.io.Serializable;

public class Empleado implements Serializable {

    private String nombre;
    private String apellido;
    private Integer legajo;
    private Double sueldo;

    public Empleado(String nombre, String apellido, Integer legajo, Double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo=" + legajo +
                ", sueldo=" + sueldo +
                '}';
    }
}
