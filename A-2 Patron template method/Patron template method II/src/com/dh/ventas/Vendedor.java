package com.dh.ventas;

public abstract class Vendedor {
    protected String nombre;
    protected int ventas;
    protected int PUNTOS_POR_VENTAS;

    public void vender(int cantidadVentas){
        this.ventas+=cantidadVentas;
    }
    public abstract int calcularPuntos();
        public String mostrarCategoria(){
            int puntosDelVendedor=calcularPuntos();
            return this.nombre + " tiene un total de " +puntosDelVendedor +" el cual categoriza como" + getNombreCategoria();
        }
    public String getNombreCategoria() {
        int puntosVendedor = calcularPuntos();
        if (puntosVendedor < 20) {
            return "novato";
        } else if (puntosVendedor < 31) {
            return "aprendiz";
        } else if (puntosVendedor < 41) {
            return "bueno";
        } else {
            return "maestro";
        }
    }

}

