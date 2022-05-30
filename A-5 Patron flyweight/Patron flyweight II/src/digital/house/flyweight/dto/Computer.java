package digital.house.flyweight.dto;

public class Computer {
    private int ram;
    private int disco;
    private static int contador;

    public Computer(int ram, int disco) {
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("contador "+ contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computer.contador = contador;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", disco=" + disco +
                '}';
    }
}
