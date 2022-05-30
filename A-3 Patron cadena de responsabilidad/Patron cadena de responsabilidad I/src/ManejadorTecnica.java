public class ManejadorTecnica extends Manejador{
    @Override
    public void comprobar(Mail elmail) {
        if ((elmail.getDestino().equalsIgnoreCase(("tecnica@comena.com"))||
                elmail.getTema().equalsIgnoreCase("tecnica")))
        {
            System.out.print("Enviado a tecnica");
        }
        else
        {
            if (this.getSiguienteManejador()!=null){
                //llegamos al método en el siguiente e
                this.getSiguienteManejador().comprobar(elmail);
            }
        }

    }
}
