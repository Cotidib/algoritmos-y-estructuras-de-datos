import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("alumnos\\src\\aeropuertos_1.txt", "alumnos\\src\\conexiones_1.txt",
                false, TGrafoDirigido.class);

        // Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        // Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        // UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        // Double[][] mfloyd = gd.floyd();
        // UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        // for (int i = 0; i < etiquetasarray.length; i++) {
        //     System.out.println("excentricidad de " + etiquetasarray[i] + " : "
        //             + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        // }
        // System.out.println();
        // System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        // System.out.println();
        System.out.println("\nEjercicio 2: ");

        Collection<TVertice> recorrido = gd.bpf();
        // imprimir etiquetas del bpf de todo el grafo....
        for (TVertice vertice : recorrido) {
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println("\nRecorrido Rio de Janeiro:");
        Collection<TVertice> recorrido1 = gd.bpf("Rio_de_Janeiro");
        for (TVertice vertice : recorrido1) {
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println("\nRecorrido Rio de Janeiro: ");
        TVertice verticeRJ = new TVertice<>("Rio_de_Janeiro");
        Collection<TVertice> recorrido2 = gd.bpf(verticeRJ);
        for (TVertice vertice : recorrido2) {
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println();

    }
}