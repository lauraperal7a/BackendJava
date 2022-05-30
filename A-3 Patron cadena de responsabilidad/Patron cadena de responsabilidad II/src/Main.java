public class Main {
    public static void main(String[] args) {
        // write your code here
        CompruebaCalidad compruebaCalidad =  new CompruebaCalidad();

        compruebaCalidad.validar(new Articulo("Cuaderno", 1500, 1200, "sano"));
        compruebaCalidad.validar(new Articulo("Papel", 2100, 1500, "peligroso"));


    }
}
