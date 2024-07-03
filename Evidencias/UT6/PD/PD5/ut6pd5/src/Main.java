import java.util.*;

public class Main {

    public static void main(String[] args) {
        TArbolTrieHashMap trie = new TArbolTrieHashMap();
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo("src\\abonados.txt");
        for (String linea : lineas){
            String[] data = linea.split(",");
            TAbonado abonado = new TAbonado(data[1], data[0]);
            trie.insertar(abonado);
        }

        trie.imprimir();
        
        String[] codigos = manejadorArchivos.leerArchivo("src\\codigos1.txt");
        String codigoPais = codigos[0].split(":")[1].trim();
        String codigoArea = codigos[1].split(":")[1].trim();
        LinkedList<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        String[] lineas2 = new String[ab.size()];
        for (int i = 0; i < ab.size(); i++) { 
            // System.out.print(ab.get(i) + " "); 
            String linea2 = ab.get(i).getNombre() + " , " + ab.get(i).getTelefono();
            lineas2[i] = linea2;
        }
        manejadorArchivos.escribirArchivo("salida.txt", lineas2);


        
    }
}