package Actividad4parte1;

public class Auto {
    // Composición: Engine se crea y se destruye junto con Car
    private Motor engine;
    
    // Agregación: Driver se referencia y puede existir de forma independiente
    private Conductor driver;
    
    public Auto(Conductor driver) {
        this.engine = new Motor(); // Creación interna del Engine (composición)
        this.driver = driver;       // Asignación del Driver (agregación)
    }
    
    public void startCar() {
        System.out.println("El automóvil arranca con motor: " + engine.getEngineType());
    }
    
    // Dependencia (Abstracción): utiliza la interfaz Service para realizar el mantenimiento
    public void performMaintenance(Servicio service) {
        service.performServicio();
    }
}

    
    

