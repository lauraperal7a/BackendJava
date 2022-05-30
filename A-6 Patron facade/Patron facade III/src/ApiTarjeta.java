public class ApiTarjeta {

    public int descuento(Tarjeta unaTarjeta){
        if (unaTarjeta.getBanco().compareTo("Star Bank")==0) {
            return 20;
        }
        else {
            return 0;
        }
    }
}
