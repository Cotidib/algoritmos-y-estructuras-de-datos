
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.GeneradorDatosGenericos;
import com.example.TClasificador;

public class ClasificacionTest {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICK = 4;
    TClasificador clasif = new TClasificador();
    GeneradorDatosGenericos gdg = new GeneradorDatosGenericos(10000);
    int[] vectorAleatorio;
    int[] vectorAscendente;
    int[] vectorDescendente;

    @BeforeEach
    void init(){
    }
    
    @Test
    public void clasificacion_QuickSort_Aleatorio(){
        vectorAleatorio = gdg.generarDatosAleatorios();
        int[] resAleatorio = clasif.clasificar(vectorAleatorio,	METODO_CLASIFICACION_QUICK);
        Assertions.assertEquals(true, clasif.estaOrdenado(resAleatorio));
    }

    @Test
    public void clasificacion_QuickSort_Ascendente(){
        vectorAscendente = gdg.generarDatosAscendentes();
        int[] resAscendente = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_QUICK);
        Assertions.assertEquals(true, clasif.estaOrdenado(resAscendente));
    }

    @Test
    public void clasificacion_QuickSort_Descendente(){
        vectorDescendente = gdg.generarDatosDescendentes();	
        int[] resDescendente = clasif.clasificar(vectorDescendente,	METODO_CLASIFICACION_QUICK);
        Assertions.assertEquals(true, clasif.estaOrdenado(resDescendente));
    }

}
