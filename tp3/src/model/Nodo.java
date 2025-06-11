package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {

    private T dato;
    private List<INodo<T>> vecinos;

    public Nodo(T dato) {
        this.dato = dato;
        this.vecinos = new ArrayList<>();
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public void agregarVecino(INodo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    @Override
    public List<INodo<T>> getVecinos() {
        return vecinos;
    }
}
