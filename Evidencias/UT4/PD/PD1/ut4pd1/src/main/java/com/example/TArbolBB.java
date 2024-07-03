package com.example;

public class TArbolBB<T> implements IArbolBB<T> {
    private TElementoAB raiz;


    @Override
    public void insertar(Comparable etiqueta, T dato) {
        TElementoAB raiz = this.raiz;
        if (raiz == null) {
            this.raiz = new TElementoAB(etiqueta, dato);
        } else {
            raiz.insertar(etiqueta, dato);
        }
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }
    @Override
    public String preOrden() {
        if (this.raiz != null) {
            return this.raiz.preOrden();
        }
        return null;
    }

    @Override
    public String inOrden() {
        if (this.raiz != null) {
            return this.raiz.inOrden();
        }
        return null;
    }

    @Override
    public String postOrden() {
        if (this.raiz != null) {
            return this.raiz.postOrden();
        }
        return null;
    }

    @Override
    public T eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        } else {
            return null;
        }
        return null;
    }

    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura(this.raiz);
        }
        return -1;
    }

    public int obtenerTamanio() {
        if (raiz != null) {
            return raiz.obtenerTamanio(this.raiz);
        }
        return 0;
    }
}
