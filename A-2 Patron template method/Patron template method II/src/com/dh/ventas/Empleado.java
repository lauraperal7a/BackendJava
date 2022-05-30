package com.dh.ventas;

import java.util.ArrayList;

public class Empleado extends Vendedor{
    private int aniosDeAntiguedad;
    private ArrayList<Vendedor> afiliado=new ArrayList<>();

    public Empleado(int aniosDeAntiguedad, ArrayList<Vendedor> afiliado) {
        super.nombre=nombre;
        super.PUNTOS_POR_VENTAS=5;
        this.aniosDeAntiguedad = aniosDeAntiguedad;
        this.afiliado = afiliado;
    }
    public void addAfiliado(Vendedor afiliado){
        this.afiliado.add(afiliado);

    }
    @Override
    public int calcularPuntos(){
        return this.afiliado.size()*10;
    }
}
