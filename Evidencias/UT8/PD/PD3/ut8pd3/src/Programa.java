
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src\\barrio.txt",
                "src\\distancias.txt",
                false, TGrafoRedElectrica.class);
       
        /*
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        */

        TAristas mejorRed = laRed.mejorRedElectrica();
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = new String[mejorRed.size()];
        for (int i = 0; i < mejorRed.size(); i++) { 
            String linea = mejorRed.get(i).getEtiquetaOrigen() + " " + mejorRed.get(i).getEtiquetaDestino() + " " + mejorRed.get(i).getCosto();
            System.out.println(linea);
            lineas[i] = linea;
        }
        manejadorArchivos.escribirArchivo("redelectrica.txt", lineas);
    }
}
