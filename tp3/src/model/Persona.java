package model;

import interfaces.IPersona;

public class Persona implements IPersona {
    private String nombre;
    private int id;  // Se asume que "id" es el DNI

    public Persona(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getDni() {
        return id;
    }

    @Override
    public void setDni(int dni) {
        this.id = dni;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona otra = (Persona) obj;
        return this.id == otra.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
