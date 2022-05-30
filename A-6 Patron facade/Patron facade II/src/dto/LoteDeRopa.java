package dto;

import factory.RopaFactory;

import java.util.ArrayList;
import java.util.List;

public class LoteDeRopa {
    private List<Ropa> prendas;

    public LoteDeRopa() {
        this.prendas = new ArrayList<>();
    }
    public void addRopa(String talle, String tipo, boolean esNuevo, String importada){
        this.prendas.add(RopaFactory.obtenerRopa(talle, tipo, esNuevo, importada));
    }
}
