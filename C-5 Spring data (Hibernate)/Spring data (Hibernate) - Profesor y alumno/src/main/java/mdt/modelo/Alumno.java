package mdt.modelo;

import javax.persistence.*;

@Entity
@Table
public class Alumno {

    @Id
    @SequenceGenerator(name = "alumno_sequence", sequenceName = "alumno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_sequence")
    private Long id;
    private String nombre;
    private Integer edad;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    public Alumno(){

    }

    public Alumno(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
