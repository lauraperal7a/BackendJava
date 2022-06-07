package org.example;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String nombre;
    private String mail;
    private Integer telefono;

    public Contacto(String nombre, String mail, Integer telefono) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public Integer getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
