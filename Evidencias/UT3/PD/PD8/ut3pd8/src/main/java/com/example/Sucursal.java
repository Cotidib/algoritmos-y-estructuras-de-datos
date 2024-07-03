package com.example;

public class Sucursal implements ISucursal {
  String nombre;

  public Sucursal (String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String getNombre() {
      return nombre;
  }

  @Override
  public void setNombre(String nombre) {
      this.nombre = nombre;
  }
}
