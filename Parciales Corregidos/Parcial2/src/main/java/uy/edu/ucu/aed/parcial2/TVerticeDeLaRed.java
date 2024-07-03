package uy.edu.ucu.aed.parcial2;

import uy.edu.ucu.aed.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class TVerticeDeLaRed extends TVertice<TEstacionDeLaRed> {

    private static TEstacionDeLaRed crearNodo(String unaEtiqueta, String tipoDeVertice) {
        String[] parts = unaEtiqueta.split("_");
        int id = Integer.parseInt(parts[1]);

        TipoDeEstacion tipo = TipoDeEstacion.fromInt(Integer.parseInt(tipoDeVertice));

        return new TEstacionDeLaRed(id, unaEtiqueta, tipo);
    }

    public TVerticeDeLaRed(Object... args) { 
        super((String) args[0]);
    
        this.datos = crearNodo((String) args[0], (String) args[1]);
    }

    public TCaminos caminosDesdeHasta(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia<TEstacionDeLaRed> adyacencia : this.getAdyacentes()) {
            TVerticeDeLaRed destino = (TVerticeDeLaRed) adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    if(destino.getDatos().getTipo().name().equals("TREN")) {
                        caminoPrevio.agregarAdyacencia(adyacencia);
                        destino.caminosDesdeHasta(etVertDest, caminoPrevio, todosLosCaminos);
                        caminoPrevio.eliminarAdyacencia(adyacencia);
                    }
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
}
