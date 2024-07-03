package com.example;

public class TArbolEA<T> {
    public TElemento raiz;

    public void inicializar(Cola expresion){
        this.raiz = TElemento.inicializarExpresion(expresion);
    }

    public int evaluar(){
        if (this.raiz != null){
            return this.raiz.evaluar(this.raiz);
        } else {
            return -1;
        }
    }

    public void reemplazar(Comparable unaEtiqueta, T valor) {
        if (raiz == null) {
            return;
        } else {
            raiz.reemplazar(unaEtiqueta, valor);
        }
    }

    public String preOrden() {
        if (this.raiz != null) {
            return this.raiz.preOrden();
        }
        return null;
    }

    public String inOrden() {
        if (this.raiz != null) {
            return this.raiz.inOrden();
        }
        return null;
    }

    public String postOrden() {
        if (this.raiz != null) {
            return this.raiz.postOrden();
        }
        return null;
    }



}
