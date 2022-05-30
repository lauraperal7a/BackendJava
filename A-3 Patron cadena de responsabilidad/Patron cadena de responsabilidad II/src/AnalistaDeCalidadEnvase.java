public class AnalistaDeCalidadEnvase extends AnalistaDeCalidad{
    @Override
    public void validar(Articulo articulo) {
        if ((articulo.getEnvasado().equalsIgnoreCase("sano"))||(articulo.getEnvasado().equalsIgnoreCase("casi sano"))){
            System.out.print("Aprobado");
        }
        else
        {
            System.out.print("Rechazado");
        }
    }
}
