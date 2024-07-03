

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieMap implements Serializable {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private HashMap<Comparable,TNodoTrieMap> hijos;
    private boolean esPalabra;

    public TNodoTrieMap() {
        hijos = new HashMap<Comparable,TNodoTrieMap>();
        esPalabra = false;
    }

    public void insertar(String unaPalabra) {
        TNodoTrieMap nodo = this;
        char[] arr = unaPalabra.toCharArray();
        for (int c = 0; c < unaPalabra.length(); c++) {
            char caracter = arr[c];
            if (!nodo.hijos.containsKey(caracter)) {
                nodo.hijos.put(caracter, new TNodoTrieMap());
            }
            nodo = nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            nodo.hijos.forEach((key, value) -> {
                if(value!= null) {
                    imprimir(s + key, value);
                }
            });
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            nodo.hijos.forEach((key, value) -> {
                if(value!= null) {
                    predecir(s + key, prefijo, palabras, value);
                }
            });
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieMap nodo = buscarNodoTrie(prefijo);
        predecir("", prefijo, palabras, nodo);
    }

    private TNodoTrieMap buscarNodoTrie(String unaPalabra) {
        TNodoTrieMap nodo = this;
        char[] arr = unaPalabra.toCharArray();
        for (int c = 0; c < unaPalabra.length(); c++) {
            char caracter = arr[c];
            if (!nodo.hijos.containsKey(caracter)) {
                return null;
            }
            nodo = nodo.hijos.get(caracter);
        }
        return nodo;
    }

}
