package uy.edu.ucu.aed;

/**
 *
 * @author abadie
 */
public class Main {
    
    public static void main(String[] args) {
        /**
         * Instanciar almacen
         * Agregar: productos y cantidades (altas.txt)
         * Emitir listado de productos y cantidades
         * Emitir valor de stock de todo el almacen
         * Vender: restar stock de productos indicado en ventas.txt
         * Emitir valor de stock de todo el almacen
         **/
        Almacen almacen = new Almacen("Supermercado", "18 de Julio 1234", "2400 1234");
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineasAltas = manejadorArchivos.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\altas.txt");
        for (String linea : lineasAltas) {
            String[] datos = linea.split(",");
            Producto producto = new Producto();
            producto.setCodProducto(Integer.parseInt(datos[0]));
            producto.setNombre(datos[1]);
            producto.setPrecio(Integer.parseInt(datos[2]));
            producto.agregarCantidadStock(Integer.parseInt(datos[3]));
            almacen.insertarProducto(producto);
        }
        // System.out.println(almacen.imprimirSeparador("\n"));
        long valorStockAltas = almacen.obtenerValorStock();
        System.out.println("Valor de stock despues de altas: " + valorStockAltas);

        String[] lineasVentas = manejadorArchivos.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\ventas.txt");
        for (String linea : lineasVentas) {
            String[] datos = linea.split(",");
            almacen.restarStock(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
            // TODO, ARREGLAR RESTAR STOCK!!!!!
        }
        long valorStockVentas = almacen.obtenerValorStock();
        System.out.println("Valor de stock despues de ventas: " + valorStockVentas);
        System.out.println("Diferencia de stock: " + (valorStockAltas - valorStockVentas));

    }
    
}
