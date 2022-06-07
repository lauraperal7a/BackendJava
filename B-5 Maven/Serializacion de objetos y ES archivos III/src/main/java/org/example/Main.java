package org.example;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // DESAFIO 1

        Empresa empresa = new Empresa(123456789, "DH");

        Empleado e1 = new Empleado("Pepito", "Perez", 1, 1000.0);
        Empleado e2 = new Empleado("Susana", "Jimenez", 2, 1500.0);
        Empleado e3 = new Empleado("Ambrosio", "Garcia", 3, 2000.0);
        Empleado e4 = new Empleado("Marta", "Habla", 4, 2100.0);

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);
        empresa.agregarEmpleado(e4);

        FileOutputStream fo;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(empresa);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Empresa empresa1;
        FileInputStream fi;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            empresa1 = (Empresa) ois.readObject();
            System.out.println(empresa1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // DESAFIO 2
        // https://www.ecodeup.com/como-escribir-y-leer-archivos-de-texto-plano-en-java/

        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("empleados.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Empleado empleado : empresa.getListaEmpleados()) {
                bfwriter.write(empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo()
                        + ";" + empleado.getSueldo() + "\n");
            }
            bfwriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}