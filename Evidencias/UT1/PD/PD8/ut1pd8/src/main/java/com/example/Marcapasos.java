package com.example;

public class Marcapasos {
  short presionSanguinea;
  short frecuenciaCardiaca;
  short azucarSangre;
  float maximaFuerza;
  byte minimoTiempoLatidos;
  byte bateria;
  char[] codigoFabricante = new char[8];

  public Marcapasos (short presionSanguinea, short frecuenciaCardiaca, short azucarSangre, float maximaFuerza, byte minimoTiempoLatidos, byte bateria, char[] codigoFabricante){
    this.presionSanguinea = presionSanguinea;
    this.frecuenciaCardiaca = frecuenciaCardiaca;
    this.azucarSangre = azucarSangre;
    this.maximaFuerza = maximaFuerza;
    this.minimoTiempoLatidos = minimoTiempoLatidos;
    this.bateria = bateria;
    this.codigoFabricante = codigoFabricante;
  }
}
