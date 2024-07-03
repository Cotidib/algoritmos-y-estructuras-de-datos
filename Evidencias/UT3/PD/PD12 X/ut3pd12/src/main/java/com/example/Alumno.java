package com.example;

public class Alumno {
  int cedula ;
  String nombre;
  String apellido = null;

  public Alumno(int cedula, String nombre, String apellido){
    this.cedula = cedula;
    this.nombre = nombre;
    this.apellido = apellido;
  }
}
