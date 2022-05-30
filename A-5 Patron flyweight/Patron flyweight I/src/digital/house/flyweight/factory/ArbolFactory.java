package digital.house.flyweight.factory;

import digital.house.flyweight.dto.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map <String, Arbol> nuevoArbol = new HashMap<>();
    public Arbol getArbol( double alto, double ancho, String color){
        String clave = "Key:"+ alto + ":"+ ancho +":"+color;
        System.out.println(clave);
        if (!nuevoArbol.containsKey(clave)){
            nuevoArbol.put(clave, new Arbol(alto, ancho,color));
            System.out.println("Nuevo arbol creado");
            return nuevoArbol.get(clave);
        }
        System.out.println("Arbol obtenido del Hashmap");
        return nuevoArbol.get(clave);
    }
}
