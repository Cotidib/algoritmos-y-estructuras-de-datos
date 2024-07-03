import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        String prefijo = pais + area;
        LinkedList lista = new LinkedList<>();
        if (raiz != null){
           raiz.buscarTelefonos(prefijo, lista);
           return lista;
        }
        return null;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(unAbonado);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
 
}
