

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements Serializable {

    private HashMap<Comparable,TNodoTrieHashMap> hijos;
    private boolean esPalabra;
    public TAbonado abonado;

    public TNodoTrieHashMap() {
        hijos = new HashMap<Comparable,TNodoTrieHashMap>();
        esPalabra = false;
    }

    public void insertar(TAbonado abonado) {
        TNodoTrieHashMap nodo = this;
        char[] arr = abonado.getTelefono().toCharArray();
        for (int c = 0; c < arr.length; c++) {
            char caracter = arr[c];
            if (!nodo.hijos.containsKey(caracter)) {
                nodo.hijos.put(caracter, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
        nodo.abonado = abonado;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
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

    private void predecir(String s, String prefijo, LinkedList<TAbonado> abonados, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.abonado);
            }
            nodo.hijos.forEach((key, value) -> {
                if(value!= null) {
                    predecir(s + key, prefijo, abonados, value);
                }
            });
        }
    }

    public void predecir(String prefijo, LinkedList<TAbonado> abonados) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        predecir("", prefijo, abonados, nodo);
    }

    private TNodoTrieHashMap buscarNodoTrie(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
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
    
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieHashMap nodo = buscarNodoTrie(primerosDigitos);
        if (nodo != null){
            predecir("", primerosDigitos, abonados, nodo);
        }
    }

}
