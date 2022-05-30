package com.dh.liquidacionsueldo.main.model;

class EmpleadoContratado extends Empleado {
    private int horasTrabajadas;
    private int valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, int horasTrabajadas, int valorHora) {
        super(nombre, apellido, numeroDeCuenta);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }
    public int getHorasTrabajadas() {
        return this.horasTrabajadas;
    }
    public int getValorHora() {
        return this.valorHora;
    }
}
