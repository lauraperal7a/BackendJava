package mdt.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Profesor {

    @Id
    @SequenceGenerator(name = "profesor_sequence", sequenceName = "profesor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_sequence")
    private Long id;
    private String nombre;
    private String titulo;
    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();

    public Profesor(){

    }

    public Profesor(String nombre, String titulo) {
        this.nombre = nombre;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
