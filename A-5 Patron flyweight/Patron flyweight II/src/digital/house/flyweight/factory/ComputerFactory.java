package digital.house.flyweight.factory;

import digital.house.flyweight.dto.Computer;
import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {
    private static Map<String, Computer> macLigero = new HashMap<>();
    public Computer getComputer(int ram, int disco){
        String clave = "Key: "+ ram +":" + disco;
        System.out.println(clave);
        if (!macLigero.containsKey(clave)){
            macLigero.put(clave, new Computer(ram, disco));
            System.out.println("PC CREADA DE CERO");
            return macLigero.get(clave);
        }
        System.out.println("PC OBTENIDA DEL HASMAP");
        return macLigero.get(clave);
    }
}


