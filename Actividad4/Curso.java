package Actividad4;

public class Curso {
    private String nombre;
    // El curso está compuesto por 3 materias
    private Materia[] materias;

    // Constructor por defecto
    public Curso() {
        this.nombre = "";
        this.materias = new Materia[3];  // Inicialmente vacías
    }

    // Constructor con parámetros
    public Curso(String nombre, Materia[] materias) {
        this.nombre = nombre;
        // Aseguramos que sean exactamente 3 materias
        if (materias != null && materias.length == 3) {
            this.materias = materias;
        } else {
            this.materias = new Materia[3];
        }
    }

    // Constructor de copia
    public Curso(Curso other) {
        this.nombre = other.nombre;
        this.materias = new Materia[3];
        // Copiamos cada Materia utilizando su constructor de copia
        for (int i = 0; i < other.materias.length; i++) {
            if (other.materias[i] != null) {
                this.materias[i] = new Materia(other.materias[i]);
            } else {
                this.materias[i] = null;
            }
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        if (materias != null && materias.length == 3) {
            this.materias = materias;
        }
    }

    // Método para calcular el total de créditos del curso
    public int getCreditosTotales() {
        int total = 0;
        for (Materia m : materias) {
            if (m != null) {
                total += m.getCreditos();
            }
        }
        return total;
    }

    // Método para calcular el total de horas semanales del curso
    public int getHorasSemanalesTotales() {
        int total = 0;
        for (Materia m : materias) {
            if (m != null) {
                total += m.getHorasSemanales();
            }
        }
        return total;
    }

    // Método toString para imprimir información
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", materias=[");
        for (int i = 0; i < materias.length; i++) {
            sb.append(materias[i]);
            if (i < materias.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}

