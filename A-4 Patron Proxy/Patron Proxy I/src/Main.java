public class Main {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("123456","premium");
        Descarga descarga = new ServicioDescargaProxy();
        descarga.descargar(u1.datos());
        Usuario u2 = new Usuario("123456","standar");
        Descarga descarga1 = new ServicioDescargaProxy();
        descarga1.descargar(u2.datos());
    }
}
