package Actividad4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Listas para almacenar los objetos creados
    private static ArrayList<Profesor> profesores = new ArrayList<>();
    private static ArrayList<Materia> materias = new ArrayList<>();
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Crear Profesor");
            System.out.println("2. Crear Materia");
            System.out.println("3. Crear Curso");
            System.out.println("4. Crear Alumno");
            System.out.println("5. Asignar Materia a Profesor");
            System.out.println("6. Quitar Materia a Profesor");
            System.out.println("7. Asignar Curso a Alumno");
            System.out.println("8. Mostrar Información");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    crearProfesor(sc);
                    break;
                case 2:
                    crearMateria(sc);
                    break;
                case 3:
                    crearCurso(sc);
                    break;
                case 4:
                    crearAlumno(sc);
                    break;
                case 5:
                    asignarMateriaAProfesor(sc);
                    break;
                case 6:
                    quitarMateriaAProfesor(sc);
                    break;
                case 7:
                    asignarCursoAAlumno(sc);
                    break;
                case 8:
                    mostrarInformacion();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 9);

        sc.close();
    }

    // Opción 1: Crear Profesor
    private static void crearProfesor(Scanner sc) {
        System.out.println("\n--- Crear Profesor ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Número de nómina: ");
        String numNomina = sc.nextLine();
        System.out.print("Sueldo por hora: ");
        double sueldoPorHora = sc.nextDouble();
        sc.nextLine(); // Consumir salto de línea

        // Inicialmente, el profesor no tiene materia asignada (null)
        Profesor profesor = new Profesor(nombre, numNomina, sueldoPorHora, null);
        profesores.add(profesor);
        System.out.println("Profesor creado exitosamente.");
    }

    // Opción 2: Crear Materia
    private static void crearMateria(Scanner sc) {
        System.out.println("\n--- Crear Materia ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Clave: ");
        String clave = sc.nextLine();
        System.out.print("Créditos: ");
        int creditos = sc.nextInt();
        System.out.print("Horas semanales: ");
        int horasSemanales = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        Materia materia = new Materia(nombre, clave, creditos, horasSemanales);
        materias.add(materia);
        System.out.println("Materia creada exitosamente.");
    }

    // Opción 3: Crear Curso
    private static void crearCurso(Scanner sc) {
        System.out.println("\n--- Crear Curso ---");
        System.out.print("Nombre del curso: ");
        String nombreCurso = sc.nextLine();

        if (materias.size() < 3) {
            System.out.println("No hay suficientes materias (mínimo 3) para crear un curso.");
            return;
        }

        Materia[] materiasDelCurso = new Materia[3];
        System.out.println("Lista de materias disponibles:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(i + ". " + materias.get(i).getNombre() +
                               " (Clave: " + materias.get(i).getClave() + ")");
        }

        for (int i = 0; i < 3; i++) {
            boolean materiaValida = false;
            while (!materiaValida) {
                System.out.print("Ingresa el índice de la materia " + (i + 1) + ": ");
                int indiceMateria = sc.nextInt();
                sc.nextLine();

                if (indiceMateria < 0 || indiceMateria >= materias.size()) {
                    System.out.println("Índice inválido. Intenta de nuevo.");
                } else {
                    Materia materiaSeleccionada = materias.get(indiceMateria);
                    boolean yaSeleccionada = false;
                    for (int j = 0; j < i; j++) {
                        if (materiasDelCurso[j] == materiaSeleccionada) {
                            yaSeleccionada = true;
                            break;
                        }
                    }

                    if (yaSeleccionada) {
                        System.out.println("Esta materia ya fue seleccionada. Elige otra.");
                    } else {
                        materiasDelCurso[i] = materiaSeleccionada;
                        materiaValida = true;
                    }
                }
            }
        }

        Curso curso = new Curso(nombreCurso, materiasDelCurso);
        cursos.add(curso);
        System.out.println("Curso creado exitosamente.");
    }
    

    // Opción 4: Crear Alumno
    private static void crearAlumno(Scanner sc) {
        System.out.println("\n--- Crear Alumno ---");
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        // Preguntamos si queremos asignar curso de una vez
        Curso cursoAsignado = null;
        if (!cursos.isEmpty()) {
            System.out.print("¿Deseas asignar un curso al alumno? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                // Mostrar lista de cursos
                for (int i = 0; i < cursos.size(); i++) {
                    System.out.println(i + ". " + cursos.get(i).getNombre());
                }
                System.out.print("Ingresa el índice del curso: ");
                int indiceCurso = sc.nextInt();
                sc.nextLine(); // Consumir salto de línea
                if (indiceCurso >= 0 && indiceCurso < cursos.size()) {
                    cursoAsignado = cursos.get(indiceCurso);
                } else {
                    System.out.println("Índice inválido. El alumno se creará sin curso.");
                }
            }
        } else {
            System.out.println("No hay cursos disponibles. El alumno se creará sin curso.");
        }

        Alumno alumno = new Alumno(matricula, nombre, edad, cursoAsignado);
        alumnos.add(alumno);
        System.out.println("Alumno creado exitosamente.");
    }

    // Opción 5: Asignar Materia a Profesor
    private static void asignarMateriaAProfesor(Scanner sc) {
        System.out.println("\n--- Asignar Materia a Profesor ---");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }

        // Mostrar profesores
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(i + ". " + profesores.get(i).getNombre() + 
                    " (Materia actual: " + (profesores.get(i).getMateria() != null 
                    ? profesores.get(i).getMateria().getNombre() : "Ninguna") + ")");
        }
        System.out.print("Ingresa el índice del profesor: ");
        int indiceProfesor = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (indiceProfesor < 0 || indiceProfesor >= profesores.size()) {
            System.out.println("Índice de profesor inválido.");
            return;
        }

        Profesor profesor = profesores.get(indiceProfesor);

        // Verificamos si ya tiene materia
        if (profesor.getMateria() != null) {
            System.out.println("Este profesor ya tiene una materia asignada: " 
                    + profesor.getMateria().getNombre());
            System.out.println("No se puede asignar otra materia.");
            return;
        }

        // Mostrar materias
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(i + ". " + materias.get(i).getNombre());
        }
        System.out.print("Ingresa el índice de la materia: ");
        int indiceMateria = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (indiceMateria < 0 || indiceMateria >= materias.size()) {
            System.out.println("Índice de materia inválido.");
            return;
        }

        Materia materiaSeleccionada = materias.get(indiceMateria);
        profesor.setMateria(materiaSeleccionada);
        System.out.println("Materia asignada exitosamente.");
    }

    // Opción 6: Quitar Materia a Profesor
    private static void quitarMateriaAProfesor(Scanner sc) {
        System.out.println("\n--- Quitar Materia a Profesor ---");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        // Mostrar profesores
        for (int i = 0; i < profesores.size(); i++) {
            Profesor p = profesores.get(i);
            System.out.println(i + ". " + p.getNombre() + 
                    " (Materia actual: " + (p.getMateria() != null 
                    ? p.getMateria().getNombre() : "Ninguna") + ")");
        }
        System.out.print("Ingresa el índice del profesor: ");
        int indiceProfesor = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (indiceProfesor < 0 || indiceProfesor >= profesores.size()) {
            System.out.println("Índice de profesor inválido.");
            return;
        }

        Profesor profesor = profesores.get(indiceProfesor);
        if (profesor.getMateria() == null) {
            System.out.println("Este profesor no tiene materia asignada.");
            return;
        }

        // Quitar materia
        profesor.setMateria(null);
        System.out.println("Materia removida exitosamente del profesor.");
    }

    // Opción 7: Asignar Curso a Alumno
    private static void asignarCursoAAlumno(Scanner sc) {
        System.out.println("\n--- Asignar Curso a Alumno ---");
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        // Mostrar alumnos
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ". " + alumnos.get(i).getNombre() +
                    " (Curso actual: " + (alumnos.get(i).getCurso() != null 
                    ? alumnos.get(i).getCurso().getNombre() : "Ninguno") + ")");
        }
        System.out.print("Ingresa el índice del alumno: ");
        int indiceAlumno = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (indiceAlumno < 0 || indiceAlumno >= alumnos.size()) {
            System.out.println("Índice de alumno inválido.");
            return;
        }

        Alumno alumno = alumnos.get(indiceAlumno);

        // Mostrar cursos
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingresa el índice del curso: ");
        int indiceCurso = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (indiceCurso < 0 || indiceCurso >= cursos.size()) {
            System.out.println("Índice de curso inválido.");
            return;
        }

        Curso cursoSeleccionado = cursos.get(indiceCurso);
        alumno.setCurso(cursoSeleccionado);
        System.out.println("Curso asignado exitosamente.");
    }

    // Opción 8: Mostrar Información
    private static void mostrarInformacion() {
        System.out.println("\n--- Mostrar Información ---");

        // Mostrar profesores
        System.out.println("\nProfesores:");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (Profesor p : profesores) {
                System.out.println(p);
                // También podemos mostrar sueldo semanal
                System.out.println("  Sueldo semanal: $" + p.calcularSueldoSemanal());
            }
        }

        // Mostrar materias
        System.out.println("\nMaterias:");
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            for (Materia m : materias) {
                System.out.println(m);
            }
        }

        // Mostrar cursos
        System.out.println("\nCursos:");
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            for (Curso c : cursos) {
                System.out.println(c);
                System.out.println("  Créditos totales: " + c.getCreditosTotales());
                System.out.println("  Horas semanales totales: " + c.getHorasSemanalesTotales());
            }
        }

        // Mostrar alumnos
        System.out.println("\nAlumnos:");
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        }
    }
}



