public class Usuario {
    private String identificador;
    private String tipoDeUsuario;

    public Usuario(String identificador, String tipoDeUsuario) {
        this.identificador = identificador;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    public Object [] datos(){
        Object [] informacion;
        informacion = new Object[2];
        informacion[0] = identificador;
        informacion[1]= tipoDeUsuario;
        return informacion;
    }
}
