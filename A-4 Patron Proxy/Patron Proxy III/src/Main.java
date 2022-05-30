
public class Main {
    public static void main(String[] args) {
        Serie s1 = new Serie();
        ISerie serie = new SerieProxy(s1);
      //  serie.getSerie("Friends");

        System.out.println(serie.getSerie("Friends"));
        System.out.println(serie.getSerie("Friends"));
        System.out.println(serie.getSerie("Friends"));
        System.out.println(serie.getSerie("Friends"));
        System.out.println(serie.getSerie("Friends"));
        System.out.println(serie.getSerie("Friends"));
        //try {

        //}catch (SerieNoHabilitadaException e){
        //    e.printStackTrace();
        //}
    }
}

