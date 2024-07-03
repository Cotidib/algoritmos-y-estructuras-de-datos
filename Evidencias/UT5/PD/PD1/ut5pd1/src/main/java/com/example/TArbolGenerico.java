package com.example;

public class TArbolGenerico<T> {
    TNodoArbolGenerico raiz;

    public TArbolGenerico(){
        this.raiz = null;
    }

    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if (this.raiz == null) {
            this.raiz = new TNodoArbolGenerico(unaEtiqueta);
            return true;
        } else {
            return raiz.insertar(unaEtiqueta,etiquetaPadre);
        }
    }

    public TNodoArbolGenerico buscar(Comparable etiqueta){
        if (this.raiz != null){
            return this.raiz.buscar(etiqueta);
        }
        return null;
    }

    public void listarIndentado(){
        if (this.raiz != null) {
            this.raiz.listarIndentado("");
        }
    }

    public String listarIndentado2(){
        if (this.raiz != null) {
            return this.raiz.listarIndentado2("");
        }
        return null;
    }

    public String preorden(){
        if (this.raiz != null) {
            return this.raiz.preorden();
        }
        return null;
    }

    public String postorden(){
        if (this.raiz != null) {
            return this.raiz.postorden();
        }
        return null;
    }

}
