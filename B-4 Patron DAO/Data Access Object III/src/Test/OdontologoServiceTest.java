package Test;

import Dao.implementa.OdontologoDaoH2;
import Model.Odontologo;
import Service.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)

public class OdontologoServiceTest {
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeClass
    public static void cargarDataSet() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo("123","Lina", "Perez"));
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo("456","Juan", "Lopez"));
        Odontologo odontologo2 = odontologoService.guardar(new Odontologo("789","Lucas", "Diaz"));
        Odontologo odontologo3 = odontologoService.guardar(new Odontologo("486","Macca", "Rojas"));
        Odontologo odontologo4 = odontologoService.guardar(new Odontologo("654","Angie", "Vidal"));
    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }
}


