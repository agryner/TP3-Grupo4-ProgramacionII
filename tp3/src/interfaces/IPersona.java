package interfaces;

public interface IPersona {
    String getNombre();
    void setNombre(String nombre);

    int getDni();
    void setDni(int dni);

    boolean equals(Object obj); 
    int hashCode(); 
}
