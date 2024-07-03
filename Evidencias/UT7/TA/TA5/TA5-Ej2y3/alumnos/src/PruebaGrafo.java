public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("alumnos\\src\\aeropuertos_1.txt","alumnos\\src\\conexiones1.txt",
                false, TGrafoDirigido.class);



        System.out.println("\nEjercicio 2: ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();
    }
}
