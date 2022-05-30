public class Serie  implements ISerie{
    @Override
    public String getSerie(String nombreSerie) {
        return "www." + nombreSerie ;
    }
}
