import dto.LoteDeRopa;

public class Application {
    public static void main(String[] args) {
        LoteDeRopa loteDeRopa = new LoteDeRopa();
        loteDeRopa.addRopa("M","Remera", true, "nacional");
        loteDeRopa.addRopa("S","Pantalon", false, "importado");
    }
}
