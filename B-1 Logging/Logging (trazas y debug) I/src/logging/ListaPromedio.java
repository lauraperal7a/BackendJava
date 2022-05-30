package logging;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaPromedio {
    private static final Logger logger = Logger.getLogger(ListaPromedio.class);
    private List<Persona> personas = new ArrayList<>();
    public ListaPromedio(List<Persona> personas){
        this.personas=personas;
    }
    public int promedioEdad (){
        int edad =0;
        for (Persona persona : personas) {
            edad = persona.getEdad()+edad;
        }
        int promedio = edad / personas.size();
        logger.info("El promedio de la lista es: "+ promedio);
        return promedio;
    }
    public Persona personaMayor(){
        Persona personaGrande= personas.get(0);
        for (Persona persona : personas){
            if (personaGrande.getEdad()>persona.getEdad()){
                personaGrande = persona;
            } else {
                personaGrande = personaGrande;
            }
        }
        logger.info("La persona mayor es: "+ personaGrande);
        return personaGrande;
    }
    public Persona personaMenor(){
        Persona personaMenor= personas.get(0);
        for (Persona persona : personas){
            if (personaMenor.getEdad()<persona.getEdad()){
                personaMenor = persona;
            } else {
                personaMenor = personaMenor;
            }
        }
        logger.info("La persona menor es: "+ personaMenor);
        return personaMenor;
    }

//    private List<Persona> enteros = new ArrayList<>();

//    public ListaPromedio(List<Integer> enteros) throws Exception {
//        this.enteros = enteros;
//        if(enteros.size() > 5) {
//            logger.info("La longituda de la lista es mayor a 5");
//        }
//        if(enteros.size() > 10) {
//            logger.info("La longituda de la lista es mayor a 10");
//        }
//        if(enteros.size() == 0) {
//            throw new Exception();
//        }
//    }
//
//    public int promedio() {
//        int sum = 0;
//        for (Integer entero: enteros) {
//            sum=+entero;
//        }
//        int promedio = sum / enteros.size();
//        logger.info("El promedio de la lista es: " + promedio);
//        return promedio;
//    }
//
//    public List<Integer> getEnteros() {
//        return enteros;
//    }
}
