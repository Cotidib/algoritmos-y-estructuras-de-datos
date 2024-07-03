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
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;

    TClasificador clasif;
    GeneradorDatosGenericos gdg;
    int[] vectorAleatorio;
    int[] vectorAscendente;
    int[] vectorDescendente;
    int[] vectorVacio;
    int[] vectorUnElemento;

    @BeforeEach
    void init() {
        clasif = new TClasificador();
        gdg = new GeneradorDatosGenericos(100);
        vectorAleatorio = gdg.generarDatosAleatorios();
        vectorAscendente = gdg.generarDatosAscendentes();
        vectorDescendente = gdg.generarDatosDescendentes();
        vectorVacio = new int[0];
        vectorUnElemento = new int[] { 42 };
    }

    @Test
    void testOrdenarPorInsercion() {
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_INSERCION);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarPorShell() {
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_SHELL);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarPorBurbuja() {
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_BURBUJA);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarPorQuickSort() {
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_QUICK);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarPorHeapSort() {
        int[] resultado = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_HEAPSORT);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarAscendentePorInsercion() {
        int[] resultado = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_INSERCION);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarDescendentePorInsercion() {
        int[] resultado = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_INSERCION);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarVectorVacioPorInsercion() {
        int[] resultado = clasif.clasificar(vectorVacio, METODO_CLASIFICACION_INSERCION);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void testOrdenarVectorUnElementoPorInsercion() {
        int[] resultado = clasif.clasificar(vectorUnElemento, METODO_CLASIFICACION_INSERCION);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(1, resultado.length);
        Assertions.assertEquals(42, resultado[0]);
    }

    @Test
    void testOrdenarAscendentePorShell() {
        int[] resultado = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_SHELL);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarDescendentePorShell() {
        int[] resultado = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_SHELL);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarVectorVacioPorShell() {
        int[] resultado = clasif.clasificar(vectorVacio, METODO_CLASIFICACION_SHELL);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void testOrdenarVectorUnElementoPorShell() {
        int[] resultado = clasif.clasificar(vectorUnElemento, METODO_CLASIFICACION_SHELL);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(1, resultado.length);
        Assertions.assertEquals(42, resultado[0]);
    }

    @Test
    void testOrdenarAscendentePorBurbuja() {
        int[] resultado = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_BURBUJA);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarDescendentePorBurbuja() {
        int[] resultado = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_BURBUJA);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarVectorVacioPorBurbuja() {
        int[] resultado = clasif.clasificar(vectorVacio, METODO_CLASIFICACION_BURBUJA);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void testOrdenarVectorUnElementoPorBurbuja() {
        int[] resultado = clasif.clasificar(vectorUnElemento, METODO_CLASIFICACION_BURBUJA);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(1, resultado.length);
        Assertions.assertEquals(42, resultado[0]);
    }

    @Test
    void testOrdenarAscendentePorQuickSort() {
        int[] resultado = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_QUICK);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarDescendentePorQuickSort() {
        int[] resultado = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_QUICK);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarVectorVacioPorQuickSort() {
        int[] resultado = clasif.clasificar(vectorVacio, METODO_CLASIFICACION_QUICK);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void testOrdenarVectorUnElementoPorQuickSort() {
        int[] resultado = clasif.clasificar(vectorUnElemento, METODO_CLASIFICACION_QUICK);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(1, resultado.length);
        Assertions.assertEquals(42, resultado[0]);
    }

    @Test
    void testOrdenarAscendentePorHeapSort() {
        int[] resultado = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_HEAPSORT);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarDescendentePorHeapSort() {
        int[] resultado = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_HEAPSORT);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
    }

    @Test
    void testOrdenarVectorVacioPorHeapSort() {
        int[] resultado = clasif.clasificar(vectorVacio, METODO_CLASIFICACION_HEAPSORT);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void testOrdenarVectorUnElementoPorHeapSort() {
        int[] resultado = clasif.clasificar(vectorUnElemento, METODO_CLASIFICACION_HEAPSORT);
        Assertions.assertTrue(clasif.estaOrdenado(resultado));
        Assertions.assertEquals(1, resultado.length);
        Assertions.assertEquals(42, resultado[0]);
    }

}
