public class RegistroVacuna implements  Registro {

    @Override
    public void registrar(Object[] datos) {
        System.out.print("Se ha generado el registro del DNI " + datos[0] +"en la fecha" + datos[1].toString());

    }
}
