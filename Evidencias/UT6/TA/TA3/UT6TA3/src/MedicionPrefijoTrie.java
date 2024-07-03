import java.util.LinkedList;

public class MedicionPrefijoTrie extends Medible {
    private TArbolTrie trie;

    public MedicionPrefijoTrie(TArbolTrie trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String palabras = (String) params[1];
        LinkedList<String> p = new LinkedList<>();
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras.split(" ")) {
                if (palabra.startsWith(palabras)) {
                    p.add(palabra);
                }
            }
        }
        System.out.println(p);
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}
