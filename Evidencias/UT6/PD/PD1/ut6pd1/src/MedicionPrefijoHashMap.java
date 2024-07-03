import java.util.HashMap;

public class MedicionPrefijoHashMap extends Medible {
    private HashMap<Integer, String> hashMap;

    public MedicionPrefijoHashMap(HashMap<Integer, String> hashMap) {
        this.hashMap = hashMap;
    }

    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String palabrasBuscar = params[1].toString(); 
        HashMap<Integer, String> p = new HashMap<>();
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : hashMap.values()) {
                if (palabra.startsWith(palabrasBuscar)) {
                    p.put(palabra.hashCode(), palabra);
                }
            }
        }
        System.out.println(p);
    }

    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
}
