package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    private Integer cuit;
    private String razonSocial;
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public Empresa(Integer cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
    }

    public void agregarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }

    public Integer getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cuit=" + cuit +
                ", razonSocial='" + razonSocial + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }
}
