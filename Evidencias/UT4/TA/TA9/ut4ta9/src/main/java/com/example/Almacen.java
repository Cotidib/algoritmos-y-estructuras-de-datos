package com.example;

import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Almacen implements IAlmacen {

    private String nombre;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        productos.insertar(unProducto.getEtiqueta(), unProducto);
    }

    @Override
    public String imprimirProductos() {
        String resultado = "";
        TElementoAB actual = productos.raiz;
        if (actual == null){
            return "";
        }
        Stack<TElementoAB> stack = new Stack<>();
        while (actual != null || !stack.isEmpty()) {
            while (actual != null) {
                stack.push(actual);
                actual = actual.getHijoIzq();
            }
            actual = stack.pop();
            String nombre = buscarPorCodigo(actual.getEtiqueta()).getNombre();
            int stock = buscarPorCodigo(actual.getEtiqueta()).getStock();
            resultado += nombre + " " + stock + " || ";
            actual = actual.getHijoDer();
        }
        return resultado;
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null){
            producto.agergarStock(cantidad);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null){
            return producto.restarStock(cantidad);
        } else {
            return -1;
        }
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB elemento = productos.buscar(clave);
        if (elemento != null){
            Producto producto = (Producto) productos.buscar(clave).getDatos();
            return producto;
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        Producto existe = productos.eliminar(clave);   
        if (existe != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int valorStock() {
        int resultado = 0;
        TElementoAB actual = productos.raiz;
        if (actual == null){
            return 0;
        }
        Stack<TElementoAB> stack = new Stack<>();
        while (actual != null || !stack.isEmpty()) {
            while (actual != null) {
                stack.push(actual);
                actual = actual.getHijoIzq();
            }
            actual = stack.pop();
            int stock = buscarPorCodigo(actual.getEtiqueta()).getStock();
            resultado += stock;
            actual = actual.getHijoDer();
        }
        return resultado;
    }

    @Override
    public int valorPrecio() {
        int resultado = 0;
        TElementoAB actual = productos.raiz;
        if (actual == null){
            return 0;
        }
        Stack<TElementoAB> stack = new Stack<>();
        while (actual != null || !stack.isEmpty()) {
            while (actual != null) {
                stack.push(actual);
                actual = actual.getHijoIzq();
            }
            actual = stack.pop();
            int stock = buscarPorCodigo(actual.getEtiqueta()).getStock();
            int precio = buscarPorCodigo(actual.getEtiqueta()).getPrecio();
            resultado += stock*precio;
            actual = actual.getHijoDer();
        }
        return resultado;
    }
   
 
   


  

   

   

   

}
