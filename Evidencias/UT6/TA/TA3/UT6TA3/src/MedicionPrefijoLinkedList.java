import java.util.LinkedList;

public class MedicionPrefijoLinkedList extends Medible {
    private LinkedList<String> linkedList;

    public MedicionPrefijoLinkedList(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }

    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String palabrasBuscar = (String) params[1];
        LinkedList<String> p = new LinkedList<>();
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : linkedList) {
                if (palabra.startsWith(palabrasBuscar)) {
                    p.add(palabra);
                }
            }
        }
        System.out.println(p);
    }
    

    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
