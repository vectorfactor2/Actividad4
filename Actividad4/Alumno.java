package Actividad4;

public class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    // Un alumno está inscrito en un curso
    private Curso curso;

    // Constructor por defecto
    public Alumno() {
        this.matricula = "";
        this.nombre = "";
        this.edad = 0;
        this.curso = null;
    }

    // Constructor con parámetros
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Constructor de copia
    public Alumno(Alumno other) {
        this.matricula = other.matricula;
        this.nombre = other.nombre;
        this.edad = other.edad;
        if (other.curso != null) {
            this.curso = new Curso(other.curso);
        } else {
            this.curso = null;
        }
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Método toString para imprimir información
    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso=" + curso +
                '}';
    }
}

