public class AnalistaDeCalidadPeso extends AnalistaDeCalidad{
    @Override
    public void validar(Articulo articulo) {
        if ((articulo.getPeso()>=1200)&&(articulo.getPeso()<=1300)){
            System.out.print("Aprobado, pasa al siguiente requisito");
            getSiguienteAnalista().validar(articulo);
        }
        else
        {
            System.out.print("Rechazado");
        }
    }
}
