package com.example;

import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("ut5ta2\\src\\main\\java\\com\\example\\palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();   
        
        System.out.println(trie.buscar("casa"));
    }
}