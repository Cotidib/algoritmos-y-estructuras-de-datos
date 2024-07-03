package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


/**
 * Unit test for implemented methods.
 */
public class Parcial1Test_Junit5
{
    String instanceVariable;
    TArbolDeProductos<Producto> arbol = new TArbolDeProductos<Producto>();

    @BeforeEach
    public void setUp() {
        Producto prod = new Producto(1, "prod1");
        Producto prod2 = new Producto(2, "prod2");
        Producto prod3 = new Producto(3, "prod3");
        Producto prod4 = new Producto(4, "prod4");
        arbol.insertar(prod2.getIdentificador() , prod2);
        arbol.insertar(prod.getIdentificador() , prod);
        arbol.insertar(prod4.getIdentificador() , prod4);
        arbol.insertar(prod3.getIdentificador() , prod3);
        instanceVariable = "Value before test";
    }

    @AfterEach
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    @Test
    public void arbolProd_obtenerListas(){
        ArrayList<Lista> resultado = new ArrayList<Lista>();
        resultado = arbol.obtenerListas();
        Lista lista1 = resultado.get(0);    //sin categoria
        Assertions.assertEquals("1 3", lista1.imprimir(" "));
        Lista lista2 = resultado.get(1);    //con categoria
        Assertions.assertEquals("2 4", lista2.imprimir(" "));
    }
}
