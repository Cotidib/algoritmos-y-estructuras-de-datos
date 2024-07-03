package com.example;

public interface IEmpresa {

  public void insertarSucursal(ISucursal unaSucursal);

  public ISucursal buscar(Comparable nombreSucursal);

  public boolean eliminar(Comparable nombreSucursal);

  public String listar(String separador);

  public int cantidadSucursales();

  public boolean directorioVacio();

}