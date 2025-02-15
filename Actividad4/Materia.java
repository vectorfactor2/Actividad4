package Actividad4;

public class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    // Constructor por defecto
    public Materia() {
        this.nombre = "";
        this.clave = "";
        this.creditos = 0;
        this.horasSemanales = 0;
    }

    // Constructor con parámetros
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    // Constructor de copia
    public Materia(Materia other) {
        this.nombre = other.nombre;
        this.clave = other.clave;
        this.creditos = other.creditos;
        this.horasSemanales = other.horasSemanales;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    // Método toString para imprimir información
    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", creditos=" + creditos +
                ", horasSemanales=" + horasSemanales +
                '}';
    }
}
