package Actividad4parte1;

public class Main {
    public static void main(String[] args) {
        // Creación de un conductor independiente
        Conductor driver = new Conductor("Juan Perez");
        
        // Creación del automóvil (Car) utilizando composición y agregación
        Auto car = new Auto(driver);
        car.startCar();
        
        // Uso de la implementación de Service para realizar el mantenimiento (dependencia por abstracción)
        Servicio maintenanceService = new serviciomanauto();
        car.performMaintenance(maintenanceService);
    }
}

