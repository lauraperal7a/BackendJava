package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contacto> contactos = new ArrayList<>();

        Contacto c1 = new Contacto("Pepito", "pepito@mail.com", 741852);
        Contacto c2 = new Contacto("Arturo", "arturo@mail.com", 753951);
        Contacto c3 = new Contacto("Anastasio", "anastasio@mail.com", 798456);
        Contacto c4 = new Contacto("Susana", "susana@mail.com", 714915);

        contactos.add(c1);
        contactos.add(c2);
        contactos.add(c3);
        contactos.add(c4);

        FileOutputStream fo;
        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(contactos);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Contacto> contactos2;
        FileInputStream fi;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            contactos2 = (List<Contacto>) ois.readObject();
            System.out.println(contactos2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}