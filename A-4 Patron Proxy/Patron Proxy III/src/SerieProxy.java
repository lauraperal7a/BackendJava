
//package com.company;
//import com.company.SerieNoHabilitadaException;

public class SerieProxy implements ISerie{
    private int cantVistas;
    private Serie laSerie; //    Serie serie; es lo mismo

    public SerieProxy(Serie laSerie) {
        this.cantVistas = 0;
        this.laSerie = laSerie;
    }

    public int getCantVistas() {
        return cantVistas;
    }

    public void setCantVistas(int cantVistas) {
        this.cantVistas = cantVistas;
    }

    public Serie getLaSerie() {
        return laSerie;
    }

    public void setLaSerie(Serie laSerie) {
        this.laSerie = laSerie;
    }

    @Override
    public String getSerie(String nombreSerie){ //throws SerieNoHabilitadaException
        if (cantVistas < 5) {
            cantVistas++ ; //incremento 1
             return laSerie.getSerie(nombreSerie);
        }
        return "Ha superado la cantidad de vistas";
        // throw new SerieNoHabilitadaException("Ha superado la cantidad de reproducciones permitidas");
    }
}
