public class ServicioDescargaProxy implements Descarga{
    Usuario usuario;
    @Override
    public void descargar(Object[] datos) {
        String status = (String) datos[1];
        if (status == "premium"){
            ServicioDescarga servicio = new ServicioDescarga();
            servicio.descargar(datos);
        }else{
            System.out.println  ("Contrate premium");
        }
    }

}
