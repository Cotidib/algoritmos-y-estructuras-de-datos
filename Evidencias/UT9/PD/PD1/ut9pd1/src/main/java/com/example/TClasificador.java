package com.example;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;

	/**
	 * Punto de entrada al clasificador
	 * 
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
		case METODO_CLASIFICACION_INSERCION:
			return ordenarPorInsercion(datosParaClasificar);
		case METODO_CLASIFICACION_SHELL:
			return ordenarPorShell(datosParaClasificar);
		case METODO_CLASIFICACION_BURBUJA:
			return ordenarPorBurbuja(datosParaClasificar);
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}


	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i = i+inc) {
					j = i;
					while ((j > 0) && (datosParaClasificar[j-1] > datosParaClasificar[j])) {
						intercambiar(datosParaClasificar, j, j - 1);
						j--;
					}
				}
			}
		}
		return datosParaClasificar;
	}


	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) { //O(N^2)
		if (datosParaClasificar != null) {
			for (int i = 1; i < datosParaClasificar.length; i++) {
				int j = i;
				while ((j > 0) && (datosParaClasificar[j-1] > datosParaClasificar[j])) {
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
		
		int[] vector = { 7,6,5,3,2};
		
		int[] insercion = clasif.clasificar(vector, METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < insercion.length; i++) {
			System.out.print(insercion[i] + " ");
		}
		System.out.println(clasif.estaOrdenado(insercion));

		int[] burbuja = clasif.clasificar(vector, METODO_CLASIFICACION_BURBUJA);
		for (int i = 0; i < burbuja.length; i++) {
			System.out.print(burbuja[i] + " ");
		}
		System.out.println(clasif.estaOrdenado(burbuja));

		int[] shell = clasif.clasificar(vector, METODO_CLASIFICACION_SHELL);
		for (int i = 0; i < shell.length; i++) {
			System.out.print(shell[i] + " ");
		}
		System.out.println(clasif.estaOrdenado(shell));

	}
}
