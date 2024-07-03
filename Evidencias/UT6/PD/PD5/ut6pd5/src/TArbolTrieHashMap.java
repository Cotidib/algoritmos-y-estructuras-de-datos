

import java.io.Serializable;
import java.util.LinkedList;

public class TArbolTrieHashMap implements Serializable{

    private TNodoTrieHashMap raiz;

    public void insertar(TAbonado abonado) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(abonado);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public LinkedList<TAbonado> predecir(String prefijo) {
        if (raiz != null) {
            LinkedList<TAbonado> abonados = new LinkedList<TAbonado>();
            raiz.predecir(prefijo,abonados);
            return abonados;
        }
        return null;
    }

    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        String prefijo = pais + area;
        LinkedList lista = new LinkedList<>();
        if (raiz != null){
           raiz.buscarTelefonos(prefijo, lista);
           return lista;
        }
        return null;
    }

}
