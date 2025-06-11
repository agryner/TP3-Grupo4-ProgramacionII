package test;

import model.Grafo;
import model.Persona;

public class TestPersonaGrafo {

    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo<>(true); // true = grafo dirigido

        Persona p1 = new Persona("Gael", 1);
        Persona p2 = new Persona("Micaela", 2);
        Persona p3 = new Persona("Agustina", 3);
        Persona p4 = new Persona("Diego", 4);

        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);

        grafo.agregarArista(p1, p2);
        grafo.agregarArista(p2, p3);
        grafo.agregarArista(p3, p4);
        grafo.agregarArista(p4, p1); // Ciclo

        grafo.mostrarMatrizAdyacencia();
        grafo.mostrarListaAdyacencia();

        grafo.bfs(p1);
        grafo.dfs(p1);
    }
}