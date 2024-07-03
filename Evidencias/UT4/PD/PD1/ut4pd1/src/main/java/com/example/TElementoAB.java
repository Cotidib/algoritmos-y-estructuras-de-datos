package com.example;

public class TElementoAB<T> implements IElementoAB{

    private T dato;
    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;

    public TElementoAB(Comparable unaEtiqueta, T unDato){
        this.dato = unDato;
        this.etiqueta = unaEtiqueta;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.buscar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                return this.hijoDer.buscar(unaEtiqueta);
            }
        }
        return null;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public Object getDatos() {
        return this.dato;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return this.quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (this.hijoIzq == null) {
            return this.hijoDer;
        }
        if (this.hijoDer == null) {
            return this.hijoIzq;
        }
        TElementoAB elHijo = this.hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = this.hijoIzq;
        }
        elHijo.hijoDer = this.hijoDer;
        return elHijo;
    }

    @Override
    public void insertar(Comparable etiqueta, Object dato) {
        if (etiqueta.compareTo(this.etiqueta) == 0) {
            return;
        } else if (etiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq == null) {
                this.hijoIzq = new TElementoAB(etiqueta, dato);
            } else {
                this.hijoIzq.insertar(etiqueta, dato);
            }
        } else if (etiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer == null) {
                this.hijoDer = new TElementoAB(etiqueta, dato);
            } else {
                this.hijoDer.insertar(etiqueta, dato);
            }
        }
    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    public int obtenerAltura(TElementoAB elemento) {
        if (elemento == null){
            return -1;
        } else {
            return 1 + Math.max(obtenerAltura(elemento.hijoIzq), obtenerAltura(elemento.hijoDer));
        }
    }

    public int obtenerTamanio(TElementoAB elemento) {
        if (elemento == null){
            return 0;
        } else {
            return 1 + obtenerTamanio(elemento.hijoIzq) + obtenerTamanio(elemento.hijoDer);
        }
    }
}
