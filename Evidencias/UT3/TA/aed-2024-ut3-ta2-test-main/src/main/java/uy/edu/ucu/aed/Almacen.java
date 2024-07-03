package uy.edu.ucu.aed;

public class Almacen  implements IAlmacen {
    String nombre;
    String direccion;
    String telefono;
    Lista<IProducto> listaProductos;

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new Lista<>();
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Lista<IProducto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public long obtenerValorStock() {
        long valorStock = 0;
        Nodo<IProducto> actual = listaProductos.primero;
        while ( actual.getSiguiente() != null) {
            valorStock += actual.getDato().getStock();
            actual = actual.getSiguiente();
        }
        return valorStock;
    }

    @Override
    public void insertarProducto(IProducto unProducto) {
        listaProductos.insertar(unProducto, unProducto.getCodProducto());
    }

    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        return listaProductos.eliminar(codProducto);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        Nodo<IProducto> actual = listaProductos.primero;
        while ( actual.getSiguiente() != null) {
            if (actual.getDato().getCodProducto() == codProducto) {
                actual.getDato().agregarCantidadStock(cantidad);
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        listaProductos.buscar(codProducto).restarCantidadStock(cantidad);
        return listaProductos.buscar(codProducto).getStock();
    }

    @Override
    public IProducto buscarPorCodigo(Comparable codProducto) {
        return listaProductos.buscar(codProducto);
    }

    @Override
    public void listarOrdenadoPorNombre() {

    }

    @Override
    public IProducto buscarPorDescripcion(String descripcion) {
        Nodo<IProducto> actual = listaProductos.primero;
        while ( actual.getSiguiente() != null) {
            if(actual.getDato().getNombre() == descripcion){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
}
