package com.example;
import java.util.ArrayList;

public class Empresa implements IEmpresa{
  ArrayList<ISucursal> listaSucursales;

  public Empresa(){
    this.listaSucursales = new ArrayList<ISucursal>();
  }

  @Override
  public void insertarSucursal(ISucursal unaSucursal) {
    listaSucursales.add(unaSucursal);
  }

  @Override
  public ISucursal buscar(Comparable nombreSucursal) {
    for (ISucursal sucursal : listaSucursales){
      if(sucursal.getNombre().equals(nombreSucursal)) {
        return sucursal;
      }
    }
    return null;
  }

  @Override
  public boolean eliminar(Comparable nombreSucursal) {
    for (int i=0;i<listaSucursales.size();i++){
      System.out.println(listaSucursales.get(i).getNombre());
      System.out.println(nombreSucursal);
      if(listaSucursales.get(i).getNombre().equals(nombreSucursal)){
        listaSucursales.remove(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public String listar(String separador) {
    String lista = " ";
    for (ISucursal sucursal : listaSucursales) {
      if (sucursal != listaSucursales.get(0)){
        lista += separador;
      }
      lista += sucursal.getNombre();
    }
    return lista;
  }

  @Override
  public int cantidadSucursales() {
    return listaSucursales.size();
  }

  @Override
  public boolean directorioVacio() {
    return listaSucursales.size() == 0;
  }
  
}
