package com.example;

public class TElemento<T>{

    private T dato;
    private Comparable etiqueta;
    private TElemento hijoIzq;
    private TElemento hijoDer;

    public TElemento(Comparable unaEtiqueta, T unDato){
        this.dato = unDato;
        this.etiqueta = unaEtiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }


    public TElemento getHijoIzq() {
        return this.hijoIzq;
    }


    public TElemento getHijoDer() {
        return this.hijoDer;
    }


    public void reemplazar(Comparable unaEtiqueta, T valor) {
        if (unaEtiqueta.equals(this.etiqueta)) {
            this.etiqueta = valor.toString();
            this.dato = valor;
        } else {
            if (this.hijoIzq != null) {
                this.hijoIzq.reemplazar(unaEtiqueta, valor);
            }
    
            if (this.hijoDer != null) {
                this.hijoDer.reemplazar(unaEtiqueta, valor);
            }
        }
    }


    public String preOrden() {
        String temp = this.etiqueta.toString();

        if (this.hijoIzq != null) {
            temp += " " + this.hijoIzq.preOrden();
        }

        if (this.hijoDer != null) {
            temp += " " + this.hijoDer.preOrden();
        }

        return temp;
    }


    public String inOrden() {
        String temp = "";

        if (this.hijoIzq != null) {
            temp += this.hijoIzq.inOrden() + " ";
        }

        temp += this.etiqueta.toString();

        if (this.hijoDer != null) {
            temp += " " + this.hijoDer.inOrden();
        }

        return temp;
    }


    public String postOrden() {
        String temp = "";

        if (this.hijoIzq != null) {
            temp += this.hijoIzq.postOrden() + " ";
        }

        if (this.hijoDer != null) {
            temp += this.hijoDer.postOrden() + " ";
        }

        temp += this.etiqueta.toString();

        return temp;
    }


    public Object getDatos() {
        return this.dato;
    }

    static public TElemento inicializarExpresion (Cola expresion){
        Nodo primero = expresion.pop();
        TElemento elemento = new TElemento(primero.getEtiqueta(), primero.getDato());
        if (elemento.esSimbolo()){
            TElemento hijoIzq = inicializarExpresion(expresion);
            TElemento hijoDer = inicializarExpresion(expresion);
            elemento.hijoDer = hijoDer;
            elemento.hijoIzq = hijoIzq;
        }
        return elemento;
    }

    public int evaluar(TElemento elemento){
        if(elemento.esSimbolo()){
            int izq = evaluar(elemento.hijoIzq);
            int der = evaluar(elemento.hijoDer);
            if(elemento.etiqueta.equals("+")){
                return izq + der;
            }
            else if(elemento.etiqueta.equals("x")){
                return izq * der;
            }
            else if(elemento.etiqueta.equals("-")){
                return izq - der;
            }
            else if(elemento.etiqueta.equals("/")){
                try {
                    return izq / der;
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            return Integer.parseInt(elemento.getDatos().toString());
        }
        return 0;
    }

    public boolean esSimbolo(){
        if (this.etiqueta.equals("+") || this.etiqueta.equals("-") || this.etiqueta.equals("x") || this.etiqueta.equals("/")) {
            return true;
        } else {
            return false;
        }
    }


}
