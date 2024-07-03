package com.example;

public class Main {
    public static void main(String[] args) {
        EnumTest bombon = new EnumTest(Ppf.BOMBON);
        bombon.getColor();

        EnumTest burbuja = new EnumTest(Ppf.BURBUJA);
        burbuja.getColor();

        EnumTest bellota = new EnumTest(Ppf.BELLOTA);
        bellota.getColor();

        System.out.println("Y asi nacieron las chicas superpoderosas, con sus ultra super poderes, ");
        for (Ppf p: Ppf.values()){
            System.out.println(p);
        }

        System.out.println("con los colores ");
        for (Ppf p: Ppf.values()){
            System.out.println(p.getPpfColor());
            // System.out.println(p.color);
        }

        ContadorPalabras contador = new ContadorPalabras();
        contador.contarVocalesYConsonantes("hola como estas");

        StringsTest.reverse("Dot saw I was Tod");
        StringsTest.reverse("Dot, saw. I, was. Tod,"); //El orden con los . y , no se mantiene igual en los dos sentidos
        StringsTest.reverse(",Dot, .saw. ,I, .was. ,Tod,");

    }
}