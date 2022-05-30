import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", "Perez", "123456789", "Vacuvid", new Date(121, 6, 5));
        Registro registro = new RegistroVacunaProxy();
        registro.registrar(p1.datos());
    }

}
