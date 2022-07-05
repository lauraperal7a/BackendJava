package com.example.entrenador.modelo;

import javax.persistence.*;

@Entity
@Table
public class Jugador {
    @Id
    @SequenceGenerator(name = "jugador_sequence", sequenceName = "jugador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence")
    private Long id;
    private String nombre;
    private String puesto;
    private int numero;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(String nombre, String puesto, int numero) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.numero = numero;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
