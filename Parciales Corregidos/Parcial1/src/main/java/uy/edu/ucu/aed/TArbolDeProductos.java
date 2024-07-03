package uy.edu.ucu.aed;

import java.util.ArrayList;

public class TArbolDeProductos<T> extends TArbolAVL<Producto> {

    public ArrayList<Lista> obtenerListas(){
        ArrayList array = new ArrayList<TElementoAB>();
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        if (this.raiz != null){
            raiz.obtenerListas(lista1, lista2);
            array.add(lista1);
            array.add(lista2);
            return array;
        }
        return null;
    }
}
