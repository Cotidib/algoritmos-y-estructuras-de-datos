package uy.edu.ucu.aed;

public class Lista<T> implements ILista<T> {

    public Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevo = new Nodo<>(clave, dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if( actual.getEtiqueta().compareTo(clave) == 0) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.getEtiqueta().compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String temp = "";
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null){
            temp += actual.getEtiqueta();
            actual = actual.getSiguiente();
        }
        return temp;
    }

    @Override
    public String imprimir(String separador) {
        String temp = "";
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null){
            temp += actual.getEtiqueta();
            actual = actual.getSiguiente();
            if (actual.getSiguiente() != null){
                temp += separador;
            }
        }
        return temp;
    }

    @Override
    public int cantElementos() {
        int size = 0;
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null){
            size += 1;
            actual = actual.getSiguiente();
        }
        return size;
    }

    @Override
    public boolean esVacia() {
        if(primero == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        if (primero == null) {
            primero = unNodo;
        } else {
            unNodo.setSiguiente(primero);
            primero = unNodo;
        }
    }

}
