package model;

public class Persona {
    private String nombre;
    private int id;

    public Persona(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

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
