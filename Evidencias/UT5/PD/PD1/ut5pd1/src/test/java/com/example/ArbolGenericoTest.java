package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArbolGenericoTest {

    TArbolGenerico<String> arbol;

    @BeforeEach
    void init(){
        arbol = new TArbolGenerico<>();
    }

    // LN: Para un arbol vacio ya creado, se llama a la funcion insertar del mismo, a modo de construir
    // un arbol donde A es la raiz, B, C y D son hijos de A, E y F son hijos de D y G es hijo de F
    // Sabiendo que el recorrido en preorden esperado para dicho arbol es ABCDEFG, comparar el resultado
    // de ejecutar un recurrido en preorden y compararlo con el valor esperado
    @Test
    public void arbolGenerico_insertar(){
        arbol.insertar("A", "");
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "A");
        arbol.insertar("E", "D");
        arbol.insertar("F", "D");
        arbol.insertar("G", "F");
        Assertions.assertEquals("A B C D E F G", arbol.preorden());
    }

    // LN: Para un arbol existente vacio,  se construye el arbol con valores conocidos y 
    // se ejecuta la funcion de buscar del arbol, ingreasando por parametro uno de los valores 
    // que fue insertar en el arbol. El resultado de la busqueda se espera que sea un objeto de
    // tipo NodoArbolGenerico, por lo que se espera que tambien tenga la misma etiqueta por la cual
    // se busco
    @Test
    public void arbolGenerico_buscar(){
        arbol.insertar("A", "");
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "A");
        arbol.insertar("E", "D");
        arbol.insertar("F", "D");
        arbol.insertar("G", "F");
        TNodoArbolGenerico buscado = arbol.buscar("G");
        Assertions.assertEquals("G", buscado.etiqueta.toString());
    }

    // LN: Para un arbol existente vacio,  se construye el arbol con valores conocidos y 
    // se ejecuta la funcion de buscar del arbol, ingreasando por parametro un valor que 
    // no pertenece al arbol. El resultado de la busqueda se espera que sea un objeto null
    @Test
    public void arbolGenerico_buscar_negativo(){
        arbol.insertar("A", "");
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "A");
        arbol.insertar("E", "D");
        arbol.insertar("F", "D");
        arbol.insertar("G", "F");
        TNodoArbolGenerico buscado = arbol.buscar("Z");
        Assertions.assertEquals(buscado, null);
    }

    // LN: Para un arbol vacio ya creado, se llama a la funcion insertar del mismo, a modo de construir
    // un arbol donde A es la raiz, B, C y D son hijos de A, E y F son hijos de D y G es hijo de F.
    // Se ejecuta la funcion de Listar Indentado del arbol y el resultado esperado tiene que ser el siguiente:
    // A  B  C  D    E    F      G
    @Test
    public void arbolGenerico_listarIndentado(){
        arbol.insertar("A", "");
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "A");
        arbol.insertar("E", "D");
        arbol.insertar("F", "D");
        arbol.insertar("G", "F");
        Assertions.assertEquals("A  B  C  D    E    F      G", arbol.listarIndentado2());
    }
}
