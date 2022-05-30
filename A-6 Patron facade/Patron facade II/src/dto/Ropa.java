package dto;

public class Ropa {
    private String talle;
    private String tipo;
    private boolean esNuevo;
    private String importada;

    public Ropa(String talle, String tipo, boolean esNuevo, String importada) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.importada = importada;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public String getImportada() {
        return importada;
    }

    public void setImportada(String importada) {
        this.importada = importada;
    }
}
