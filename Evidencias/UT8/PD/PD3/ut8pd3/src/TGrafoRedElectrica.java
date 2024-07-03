
import java.util.Collection;

public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAristas mejorRedElectrica() {
        TGrafoNoDirigido prim = this.Prim();
        TAristas aristas = prim.getLasAristas();
        return aristas;
    }

}