package com.example;

public class Empresa implements IEmpresa{
  Lista<ISucursal> listaSucursales;

  public Empresa(){
    this.listaSucursales = new Lista<>();
  }

  @Override
  public void insertarSucursal(ISucursal unaSucursal) {
    listaSucursales.insertar(unaSucursal.getNombre(), unaSucursal);
  }

  @Override
  public ISucursal buscar(Comparable nombreSucursal) {
    return listaSucursales.buscar(nombreSucursal);
  }

  @Override
  public boolean eliminar(Comparable nombreSucursal) {
    return listaSucursales.eliminar(nombreSucursal);
  }

  @Override
  public String listar(String separador) {
    return listaSucursales.imprimir(separador);
  }

  @Override
  public int cantidadSucursales() {
    return listaSucursales.cantElementos();
  }

  @Override
  public boolean directorioVacio() {
    return listaSucursales.esVacia();
  }
  
}
