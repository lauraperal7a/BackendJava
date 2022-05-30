public class ServicioDescarga implements Descarga{
    @Override
    public void descargar(Object[] datos) {
        System.out.print("Usted es usuario " + datos[1] + "puede descargar la cancion");
    }
}
