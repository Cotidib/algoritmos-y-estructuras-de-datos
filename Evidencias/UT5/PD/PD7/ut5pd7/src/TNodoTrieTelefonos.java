

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrieTelefonos[] hijos;
    private boolean esPalabra;
    public String nombreAbonado;
    public TAbonado abonado;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = buscarNodoTrie(primerosDigitos);
        if (nodo != null){
            predecir("", primerosDigitos, abonados, nodo);
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        String telefono = unAbonado.getTelefono();
        for (int c = 0; c < telefono.length(); c++) {
            int indice = telefono.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.nombreAbonado = unAbonado.getNombre();
        nodo.abonado = unAbonado;
    }

    private void imprimir(String s, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + '0'), nodo.hijos[c]);
                }
            }
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

    private void predecir(String s, String prefijo, LinkedList<TAbonado> abonados, TNodoTrieTelefonos nodo) {
        if (nodo != null){
            if (nodo.esPalabra){
                // abonados.add(prefijo + s);
                abonados.add(nodo.abonado);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++){
                if (nodo.hijos[c] != null){
                    predecir(s + (char)(c + '0'), prefijo, abonados, nodo.hijos[c]);
                }
            }
        }
    }

    public TNodoTrieTelefonos obtenerHijo(char caracter){
        char caracterMin = Character.toLowerCase(caracter);
        int posicion = caracterMin - '0';
        return hijos[posicion];
    }

    public TNodoTrieTelefonos buscarNodoTrie(String unaPalabra) {
        char[] unaPalabraArray = unaPalabra.toCharArray();
        TNodoTrieTelefonos nodoActual = this;
        for (int c = 0; c < unaPalabraArray.length; c++){
            TNodoTrieTelefonos unHijo = nodoActual.obtenerHijo(unaPalabraArray[c]);
            if(unHijo == null){
                return null;
            } else {
                nodoActual = unHijo;
            }
        }
        if(nodoActual != null){
            return nodoActual;
        } else {
            return null;
        }
    }
    
}
