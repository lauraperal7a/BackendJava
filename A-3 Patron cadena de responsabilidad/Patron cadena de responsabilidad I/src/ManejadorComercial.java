public class ManejadorComercial extends Manejador{
    @Override
    public void comprobar(Mail elmail) {
        if ((elmail.getDestino().equalsIgnoreCase(("comercial@comena.com"))||
        elmail.getTema().equalsIgnoreCase("comercial")))
        {
            System.out.print("Enviado a Comercial");
        }
        else
        {
            if (this.getSiguienteManejador()!=null){
                this.getSiguienteManejador().comprobar(elmail);
            }
        }

    }
}
