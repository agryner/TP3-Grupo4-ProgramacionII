package model;

import java.util.*;

public class Grafo<T> {

    private Map<T, Nodo<T>> nodos = new HashMap<>();
    private boolean esDirigido;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
    }

    public void agregarNodo(T dato) {
        if (!nodos.containsKey(dato)) {
            nodos.put(dato, new Nodo<>(dato));
        }
    }

    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo<T> nodoOrigen = nodos.get(origen);
            Nodo<T> nodoDestino = nodos.get(destino);

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
                Nodo<T> nodo1 = nodos.get(dato1);
                Nodo<T> nodo2 = nodos.get(dato2);
                System.out.print(nodo1.getVecinos().contains(nodo2) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, Nodo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            for (Nodo<T> vecino : entrada.getValue().getVecinos()) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<Nodo<T>> cola = new LinkedList<>();

        Nodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
            for (Nodo<T> vecino : actual.getVecinos()) {
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

    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");
        for (Nodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRec(vecino, visitados);
            }
        }
    }
}
