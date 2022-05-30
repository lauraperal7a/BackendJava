public class AnalistaDeCalidadLote extends AnalistaDeCalidad{
    @Override
    public void validar(Articulo articulo) {
       if ((articulo.getLote()>=1000)&&(articulo.getLote()<=2000)){
            System.out.print("Aprobado, pasa al siguiente requisito");
           getSiguienteAnalista().validar(articulo);
       }
       else
       {
            System.out.print("Rechazado");
       }
    }
}
