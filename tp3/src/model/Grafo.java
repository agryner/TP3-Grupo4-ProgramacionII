package model;

import java.util.*;
import interfaces.IGrafo;
import interfaces.INodo;

public class Grafo<T> implements IGrafo<T> {

    private Map<T, INodo<T>> nodos = new HashMap<>();
    private boolean esDirigido;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
    }

    public void agregarNodo(T dato) {
        if (!nodos.containsKey(dato)) {
            nodos.put(dato, new Nodo<>(dato));  // Nodo<T> implementa INodo<T>
        }
    }

    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            INodo<T> nodoOrigen = nodos.get(origen);
            INodo<T> nodoDestino = nodos.get(destino);

            if (!nodoOrigen.getVecinos().contains(nodoDestino)) {
                nodoOrigen.agregarVecino(nodoDestino);
                if (!esDirigido && !nodoDestino.getVecinos().contains(nodoOrigen)) {
                    nodoDestino.agregarVecino(nodoOrigen);
                }
            }
        }
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");

        List<T> claves = new ArrayList<>(nodos.keySet());

        // Encabezado
        System.out.print("    ");
        for (T dato : claves) System.out.print(dato + " ");
        System.out.println();

        for (T dato1 : claves) {
            System.out.print(dato1 + ": ");
            for (T dato2 : claves) {
                INodo<T> nodo1 = nodos.get(dato1);
                INodo<T> nodo2 = nodos.get(dato2);
                System.out.print(nodo1.getVecinos().contains(nodo2) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, INodo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            for (INodo<T> vecino : entrada.getValue().getVecinos()) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();

        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");
        for (INodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRec(vecino, visitados);
            }
        }
    }
}
