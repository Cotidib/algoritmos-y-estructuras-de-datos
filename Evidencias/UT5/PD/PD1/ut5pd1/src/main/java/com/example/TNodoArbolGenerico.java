package com.example;

public class TNodoArbolGenerico<T> {
    TNodoArbolGenerico padre;
    TNodoArbolGenerico hijoIzquierdo;
    TNodoArbolGenerico hermanoDerecho;
    Comparable etiqueta;

    public TNodoArbolGenerico(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }

    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        TNodoArbolGenerico nuevoHijo = new TNodoArbolGenerico(unaEtiqueta);
        TNodoArbolGenerico padre = buscar(etiquetaPadre);
        if (padre != null){
            if(padre.hijoIzquierdo == null){
                padre.hijoIzquierdo = nuevoHijo;
                return true;
            } else {
                TNodoArbolGenerico aux = padre.hijoIzquierdo;
                while ( aux.hermanoDerecho != null){
                    aux = aux.hermanoDerecho;
                }
                aux.hermanoDerecho = nuevoHijo;
                return true;
            }
        } else {
            return false;
        }
    }

    public TNodoArbolGenerico buscar(Comparable etiqueta){
        if (etiqueta.compareTo(this.etiqueta)==0){
            return this;
        }

        TNodoArbolGenerico hijo = this.hijoIzquierdo;
        while(hijo != null){
            TNodoArbolGenerico aux = hijo.buscar(etiqueta);
            if (aux != null){
                return aux;
            } else {
                hijo = hijo.hermanoDerecho;
            }
        }
        return null;
    }

    public void listarIndentado(String separador) {
        System.out.println(separador + this.etiqueta);
        if (this.hijoIzquierdo != null) {
            this.hijoIzquierdo.listarIndentado(separador + "  ");
        }
        if (this.hermanoDerecho != null) {
            this.hermanoDerecho.listarIndentado(separador);
        }
    }

    public String listarIndentado2(String separador) {
        String temp = separador + this.etiqueta.toString();
        if (this.hijoIzquierdo != null) {
            temp += this.hijoIzquierdo.listarIndentado2(separador + "  ");
        }
        if (this.hermanoDerecho != null) {
            temp += this.hermanoDerecho.listarIndentado2(separador);
        }
        return temp;
    }

    public String preorden(){
        String temp = this.etiqueta.toString();
        TNodoArbolGenerico hijo = this.hijoIzquierdo;
        while(hijo != null){
            temp += " " + hijo.preorden();
            hijo = hijo.hermanoDerecho;
        }
        return temp;
    }

    public String postorden(){
        String temp = "";
        TNodoArbolGenerico hijo = this.hijoIzquierdo;
        while(hijo != null){
            temp += hijo.postorden() + " ";
            hijo = hijo.hermanoDerecho;
        }
        temp += this.etiqueta.toString();
        return temp;
    }

}
