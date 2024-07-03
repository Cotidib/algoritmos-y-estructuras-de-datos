import java.util.*;

public class Main {

    private static final int REPETICIONES = 20;

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        TreeMap treeMap = new TreeMap();
        TArbolTrieMap trieMap = new TArbolTrieMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src\\listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src\\listado-general_palabrasBuscar.txt");
        
        for (String p : palabrasclave) {
            trie.insertar(p);
            trieMap.insertar(p);
            treeMap.put(p, p);
        }

        // trieMap.imprimir();

        Medible[] medibles = new Medible[2];
        int i = 0;
        medibles[i++] = new MedicionPrefijoTrie(trie);
        medibles[i++] = new MedicionPrefijoTrieMap(trieMap);
        Medicion mi;
        i = 0;
        Object[] params = { REPETICIONES, "cas" };
        String[] lineas = new String[3];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("salidas.csv", lineas);
    }
}