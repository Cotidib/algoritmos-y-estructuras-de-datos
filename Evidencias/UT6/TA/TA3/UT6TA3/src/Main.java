import java.util.*;

public class Main {

    private static final int REPETICIONES = 20;

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src\\listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src\\listado-general_palabrasBuscar.txt");
        
        for (String p : palabrasclave) {
            trie.insertar(p);
            linkedList.add(p);
            arrayList.add(p);
            hashMap.put(p.hashCode(), p);
            treeMap.put(p, p);

        }

        for (String p : palabrasBuscar) {
            trie.buscar(p);
            linkedList.contains(p);
            arrayList.contains(p);
            hashMap.containsKey(p.hashCode());
            treeMap.containsKey(p);

        }

        Medible[] medibles = new Medible[3];
        int i = 0;
        // medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        // medibles[i++] = new MedicionBuscarArrayList(arrayList);
        // medibles[i++] = new MedicionBuscarTrie(trie);
        // medibles[i++] = new MedicionBuscarHashMap(hashMap);
        // medibles[i++] = new MedicionBuscarTreeMap(treeMap);
        medibles[i++] = new MedicionPrefijoLinkedList(linkedList);
        medibles[i++] = new MedicionPrefijoTrie(trie);
        medibles[i++] = new MedicionPrefijoHashMap(hashMap);
        Medicion mi;
        i = 0;
        Object[] params = { REPETICIONES, "cas" };
        String[] lineas = new String[4];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();

        }

        ManejadorArchivosGenerico.escribirArchivo("salidas.csv", lineas);
    }
}