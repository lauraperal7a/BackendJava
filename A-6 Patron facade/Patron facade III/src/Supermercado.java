public class Supermercado {
    public static void main(String[] args) {
        FacadeDescuento facade = new FacadeDescuento();
        Tarjeta tarj = new Tarjeta("33443344223433", "Star Bank");
        Producto merca = new Producto("arvejas", "latas");
        System.out.println("Descuento: "+facade.descuento(tarj, merca, 0));
    }
}
