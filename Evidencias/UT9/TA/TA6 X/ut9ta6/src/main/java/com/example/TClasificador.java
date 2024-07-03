package com.example;

public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICK = 4;
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICK:
                return ordenarPorQuicksort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            default:
                System.err.println("Este código no debería haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            for (int i = inc; i < datosParaClasificar.length; i++) {
                j = i;
                while (j >= inc && datosParaClasificar[j - inc] > datosParaClasificar[j]) {
                    intercambiar(datosParaClasificar, j, j - inc);
                    j -= inc;
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i;
                while (j > 0 && datosParaClasificar[j - 1] > datosParaClasificar[j]) {
                    intercambiar(datosParaClasificar, j, j - 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) {
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r * 2 + 1 <= ultimo) {
                int hijoIzq = r * 2 + 1;
                int hijoDer = r * 2 + 2;
                int posicionIntercambio = hijoIzq;

                if (hijoDer <= ultimo && datosParaClasificar[hijoDer] > datosParaClasificar[hijoIzq]) {
                    posicionIntercambio = hijoDer;
                }

                if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
                    intercambiar(datosParaClasificar, r, posicionIntercambio);
                    r = posicionIntercambio;
                } else {
                    break;
                }
            }
        }
    }

    private int[] ordenarPorQuicksort(int[] datosParaClasificar) {
        return ordenarPorQuicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
    }

    private int[] ordenarPorQuicksort(int[] V, int i, int j) {
        if (i < j) {
            int indicePivote = encuentraPivote1(i, j, V);
            int pivote = V[indicePivote];
            int k = particion(i, j, pivote, V);
            ordenarPorQuicksort(V, i, k - 1);
            ordenarPorQuicksort(V, k, j);
        }
        return V;
    }

    public int particion(int i, int j, int pivote, int[] V) {
        int L = i;
        int R = j;
        while (L <= R) {
            while (V[L] < pivote) {
                L++;
            }
            while (V[R] > pivote) {
                R--;
            }
            if (L <= R) {
                intercambiar(V, L, R);
                L++;
                R--;
            }
        }
        return L;
    }

    public int encuentraPivote2(int i, int j, int[] entrada) {
        int mediana = 0;
        for (int m = i; m < j; m++) {
            mediana += entrada[m];
        }
        mediana = mediana / (j - i);

        int minDiferencia = Integer.MAX_VALUE;
        int pivot = i;
        for (int p = i; p < j; p++) {
            int diferencia = Math.abs(entrada[p] - mediana);
            if (diferencia < minDiferencia) {
                minDiferencia = diferencia;
                pivot = p;
            }
        }
        return pivot;
    }

    public int encuentraPivote1(int i, int j, int[] v) {
        int posicion = (i + j) / 2;
        return posicion;
    }

    public boolean estaOrdenado(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            if (datosParaClasificar[i] > datosParaClasificar[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();

        int[] vector = { 256, 458, 365, 298, 43, 648 };

        int[] quick = clasif.clasificar(vector, METODO_CLASIFICACION_HEAPSORT);
        for (int i = 0; i < quick.length; i++) {
            System.out.print(quick[i] + " ");
        }
        System.out.println(clasif.estaOrdenado(quick));
    }
}
