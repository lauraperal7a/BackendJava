public  abstract class AnalistaDeCalidad {
    protected AnalistaDeCalidad siguienteAnalista;

    public AnalistaDeCalidad getSiguienteAnalista() {
        return siguienteAnalista;
    }

    public void setSiguienteAnalista(AnalistaDeCalidad siguienteAnalista) {
        this.siguienteAnalista = siguienteAnalista;
    }
    public abstract void validar (Articulo articulo);
}
