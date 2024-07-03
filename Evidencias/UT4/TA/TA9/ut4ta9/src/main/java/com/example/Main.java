package com.example;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();

      // cargar los productos desde el archivo "altasprueba.txt"
      // listar los productos ordenados por codigo, junto con su cantidad existente
      // emitir el valor del stock
      // simular las ventas a partir del archivo "ventaspruebas.txt"
      // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
      // listar los productos ordenados por codigo, junto con su cantidad existente

      Almacen almacen = new Almacen("Supermercado");
      ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
      String[] lineasAltas = manejadorArchivos.leerArchivo("ut4ta9\\src\\main\\java\\com\\example\\altasPrueba.txt");
      for (String linea : lineasAltas) {
        String[] datos = linea.split(",");
        Producto producto = new Producto(Integer.parseInt(datos[0]), datos[1]);
        producto.setPrecio(Integer.parseInt(datos[2]));
        producto.agergarStock(Integer.parseInt(datos[3]));
        almacen.insertarProducto(producto);
      }

      System.out.println(almacen.imprimirProductos());
      int stockInicial = almacen.valorStock();
      System.out.println("Stock Inicial: " + stockInicial);
      int precioInicial = almacen.valorPrecio();
      System.out.println("Precio Inicial: " + precioInicial);

      String[] lineasVentas = manejadorArchivos.leerArchivo("ut4ta9\\src\\main\\java\\com\\example\\elimPrueba.txt");
      for (String linea : lineasVentas) {
          almacen.eliminarProducto(Integer.parseInt(linea));
      }

      int stockFinal = almacen.valorStock();
      System.out.println("Stock Final: " + stockFinal);
      System.out.println("Diferencia de Stock: " + (stockInicial - stockFinal));

      int precioFinal = almacen.valorPrecio();
      System.out.println("Precio Final: " + precioFinal);
      System.out.println("Diferencia de Precio: " + (precioInicial - precioFinal));

      System.out.println("ALMACEN 2");
      Almacen almacen2 = new Almacen("Supermercado2");
      String[] lineasAltas2 = manejadorArchivos.leerArchivo("ut4ta9\\src\\main\\java\\com\\example\\altas.txt");
      for (String linea : lineasAltas2) {
        String[] datos = linea.split(",");
        Producto producto = new Producto(Integer.parseInt(datos[0]), datos[1]);
        producto.setPrecio(Integer.parseInt(datos[2]));
        producto.agergarStock(Integer.parseInt(datos[3]));
        almacen2.insertarProducto(producto);
      }

      System.out.println(almacen2.imprimirProductos());
      int stockInicial2 = almacen2.valorStock();
      System.out.println("Stock Inicial: " + stockInicial2);
      int precioInicial2 = almacen2.valorPrecio();
      System.out.println("Precio Inicial: " + precioInicial2);
      
      String[] lineasElim = manejadorArchivos.leerArchivo("ut4ta9\\src\\main\\java\\com\\example\\elim.txt");
      for (String linea : lineasElim) {
          almacen2.eliminarProducto(Integer.parseInt(linea));
      }

      int stockFinal2 = almacen2.valorStock();
      System.out.println("Stock Final2: " + stockFinal2);
      System.out.println("Diferencia de Stock: " + (stockInicial2 - stockFinal2));
      
      int precioFinal2 = almacen2.valorPrecio();
      System.out.println("Precio Final2: " + precioFinal2);
      System.out.println("Diferencia de Precio: " + (precioInicial2 - precioFinal2));
      System.out.println(almacen2.imprimirProductos());
    }
}

