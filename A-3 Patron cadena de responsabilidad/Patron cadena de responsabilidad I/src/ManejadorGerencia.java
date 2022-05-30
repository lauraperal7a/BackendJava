public class ManejadorGerencia extends Manejador{
    @Override
    public void comprobar(Mail elmail) {
        if ((elmail.getDestino().equalsIgnoreCase(("gerencia@comena.com"))||
                elmail.getTema().equalsIgnoreCase("gerencia")))
        {
            System.out.print("Enviado a gerencia");
        }
        else
        {
            if (this.getSiguienteManejador()!=null){
                this.getSiguienteManejador().comprobar(elmail);
            }
        }

    }
}
