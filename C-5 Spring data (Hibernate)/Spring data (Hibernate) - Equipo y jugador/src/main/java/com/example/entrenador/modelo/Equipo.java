package com.example.entrenador.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Equipo {

    @Id
    @SequenceGenerator(name = "equipo_sequence", sequenceName = "equipo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipo_sequence")
    private Long id;
    private String nombre;
    private String ciudad;
    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)
    private Set<Jugador> jugadores = new HashSet<>();

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
