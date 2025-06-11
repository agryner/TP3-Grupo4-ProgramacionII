package model;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {

    private T dato;
    private List<Nodo<T>> vecinos;

    public Nodo(T dato) {
        this.dato = dato;
        this.vecinos = new ArrayList<>();
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void agregarVecino(Nodo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    public List<Nodo<T>> getVecinos() {
        return vecinos;
    }
}