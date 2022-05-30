package logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    private final static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        File log4jfile = new File("./src/logging/config/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        ListaPromedio listaPromedio = null;
        Persona persona1 = new Persona("Lucila", "Arjona", 25);
        Persona persona2 = new Persona("Adrian", "Moncada", 26);
        listaPromedio = new ListaPromedio(Arrays.asList(persona1, persona2));
        listaPromedio.promedioEdad();
        listaPromedio.personaMenor();
        listaPromedio.personaMayor();

//        ListaPromedio listaPromedioMayorA5 = null;
//        ListaPromedio listaPromedioMayorA10 = null;
//        ListaPromedio listaPromedioVacia = null;
//        try {
//            listaPromedioMayorA5 = new ListaPromedio(Arrays.asList(1, 2, 3, 4, 5, 6));
//            listaPromedioMayorA10 = new ListaPromedio(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
//            listaPromedioVacia = new ListaPromedio(new ArrayList<>());
//        } catch (Exception e) {
//            logger.error("La lista es igual a cero ", e);
//        }
        //Crear 50 personas con las siguientes propiedades:
        //nombre, apellido  y edad;
        //Mostrar por pantalla y guardar en archivo el promedio de edad de todas las personas.
        //Mostrar por pantalla La persona con más edad y menos edad.
    }
}
