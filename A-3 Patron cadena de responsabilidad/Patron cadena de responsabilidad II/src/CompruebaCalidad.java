public class CompruebaCalidad {
    AnalistaDeCalidad inicial;
    public CompruebaCalidad() {
        this.inicial = new AnalistaDeCalidadLote();
        AnalistaDeCalidad peso = new AnalistaDeCalidadPeso();
        AnalistaDeCalidad envasado = new AnalistaDeCalidadEnvase();

        inicial.setSiguienteAnalista(peso);
        peso.setSiguienteAnalista(envasado);
    }
    public void validar (Articulo articulo){
        inicial.validar(articulo);
    }

}
