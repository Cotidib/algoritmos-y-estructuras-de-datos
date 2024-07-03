package com.example;

public class Main {

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo("src\\main\\java\\com\\example\\PalabrasIndice.txt");
        for (String linea : lineas){
            trie.insertar(linea.trim());
        }

        trie.indizarLibro("src\\main\\java\\com\\example\\libro.txt");
        
        trie.imprimirIndice();
    }
}