package factory;

import dto.Ropa;

import java.util.HashMap;
import java.util.Map;

public class RopaFactory {
    private static final Map<String, Ropa> ropaMap = new HashMap<>();
    public static Ropa obtenerRopa(String talle, String  tipo, boolean esNuevo, String importado){
        Ropa ropa = ropaMap.get(tipo);
        if (ropa==null){
            ropa= new Ropa(talle, tipo, esNuevo, importado);
            ropaMap.put(tipo, ropa);
            System.out.println("Creando prenda de talle "+ talle+ "de tipo" +tipo+ "es" + esNuevo +"y es" + importado);
            //if para agregar a la listas
        }
        return ropa;

    }
}
