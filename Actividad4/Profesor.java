package Actividad4;

public class Profesor {
    private String nombre;
    private String numNomina;
    private double sueldoPorHora;
    // Un profesor solo puede impartir una materia (opcional si aún no se asigna)
    private Materia materia;

    // Constructor por defecto
    public Profesor() {
        this.nombre = "";
        this.numNomina = "";
        this.sueldoPorHora = 0.0;
        this.materia = null;
    }

    // Constructor con parámetros
    public Profesor(String nombre, String numNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numNomina = numNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia;
    }

    // Constructor de copia
    public Profesor(Profesor other) {
        this.nombre = other.nombre;
        this.numNomina = other.numNomina;
        this.sueldoPorHora = other.sueldoPorHora;
        if (other.materia != null) {
            this.materia = new Materia(other.materia);
        } else {
            this.materia = null;
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumNomina() {
        return numNomina;
    }

    public void setNumNomina(String numNomina) {
        this.numNomina = numNomina;
    }

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // Método para calcular el sueldo semanal (horas semanales de la materia * sueldoPorHora)
    public double calcularSueldoSemanal() {
        if (materia == null) {
            return 0.0;
        }
        return sueldoPorHora * materia.getHorasSemanales();
    }

    // Método toString para imprimir información
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", numNomina='" + numNomina + '\'' +
                ", sueldoPorHora=" + sueldoPorHora +
                ", materia=" + materia +
                '}';
    }
}
