package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreparadoTests {
  
  @Test
  public void PreparadoTest(){
    ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();

    Lista<Suero> sueros = new Lista<>();
    String[] lineasSueros = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\Sueros.txt");
    for (String linea : lineasSueros){
        String[] datos = linea.split(",");
        Suero nuevoSuero = new Suero(datos[1], Integer.parseInt(datos[0]));
        Nodo<Suero> nuevoNodo = new Nodo<Suero>(nuevoSuero.codigo, nuevoSuero);
        sueros.insertar(nuevoNodo);
    }

    Lista<Farmaco> farmacos = new Lista<>();
    String[] lineasFarmacos = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\Farmacos.txt");
    for (String linea : lineasFarmacos){
        String[] datos = linea.split(",");
        Farmaco nuevoFarmaco = new Farmaco(datos[1], Integer.parseInt(datos[0]));
        Nodo<Farmaco> nuevoNodo = new Nodo<Farmaco>(nuevoFarmaco.codigo, nuevoFarmaco);
        farmacos.insertar(nuevoNodo);
    }

    Lista<Farmaco> listaBlanca = new Lista<>();
    String[] lineasListaBlanca = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\listablanca.txt");
    for (String linea : lineasListaBlanca){
        Nodo<Farmaco> existe = farmacos.buscar(Integer.parseInt(linea));
        if (existe != null){
            listaBlanca.insertar(existe.getEtiqueta(), existe.getDato());
        }
    }
    
    Lista<Par<Suero,Farmaco>> listaNegra = new Lista<>();
    String[] lineasListaNegra = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\listanegra.txt");
    for (String linea : lineasListaNegra){
        String[] datos = linea.split(",");
        Nodo<Suero> existeSuero = sueros.buscar(Integer.parseInt(datos[0]));
        Nodo<Farmaco> existeFarmaco = farmacos.buscar(Integer.parseInt(datos[1]));
        if (existeSuero != null && existeFarmaco != null){
            Par<Suero,Farmaco> par = new Par<Suero,Farmaco>(existeSuero.getDato(), existeFarmaco.getDato());
            listaNegra.insertar(par.getKey().codigo,par);
        }
    }

    Preparado preparado = new Preparado(listaBlanca, listaNegra);
    Suero sueroParaPrueba = new Suero("SUERO GLUCOSADO ISOTONICO 5% SOL. X 100ML", 17);
    Lista<Farmaco> farmacosParaPrueba = new Lista<>();
    Farmaco farmacoParaPrueba1 = new Farmaco("ACETATO DE DESMOPRESINA 7 MCG/15 ML", 1);
    Farmaco farmacoParaPrueba2 = new Farmaco("CISPLATINO 150 MG", 80);
    farmacosParaPrueba.insertar(farmacoParaPrueba2.codigo, farmacoParaPrueba2);
    farmacosParaPrueba.insertar(farmacoParaPrueba1.codigo, farmacoParaPrueba1);

    boolean resultado = preparado.preparadoViable(sueroParaPrueba, farmacosParaPrueba);
    Assertions.assertEquals(false, resultado);
  }
}
