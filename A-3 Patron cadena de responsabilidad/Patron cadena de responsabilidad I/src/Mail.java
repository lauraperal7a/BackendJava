public class Mail {
    private String nombre;
    private String destino;
    private String tema;


    public Mail(String nombre, String destino, String tema) {
        this.nombre = nombre;
        this.destino = destino;
        this.tema = tema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
