//LIM

import java.util.*;



public class EmployeeCarManagement {
    public static void main(String[] args) {
        System.out.println("EMPLOYEE & CAR MANAGEMENT");


        Employee emp1 = new Employee(101, "John Doe", 75000.50);
        System.out.println("Created: " + emp1);
        System.out.println("Employee ID: " + emp1.getEmployeeId());
        System.out.println("Employee Name: " + emp1.getEmployeeName());
        System.out.println("Employee Salary: " + emp1.getEmployeeSalary());

        emp1.setEmployeeName("William Afton");
        System.out.println("\nAfter name change: " + emp1);


        Car car1 = new Car("Toyota", "Camry", 2020, 45000);
        System.out.println("Created: " + car1);
        System.out.println("Company: " + car1.getCompanyName());
        System.out.println("Model: " + car1.getModelName());
        System.out.println("Year: " + car1.getYear());
        System.out.println("Mileage: " + car1.getMileage());

        car1.setYear(2021);
        System.out.println("\nAfter year update: " + car1);


        MaintenanceCar mainCar = new MaintenanceCar("Honda", "Civic", 2019, 35000);
        mainCar.addMaintenance("Oil Change", 45.00, "2024-01-15");
        mainCar.addMaintenance("Tire Rotation", 80.00, "2024-03-20");
        mainCar.recordTrip(5000); // Drive 5000 km
        mainCar.addMaintenance("Brake Inspection", 120.00, "2024-06-10");

        System.out.println(mainCar.getMaintenanceReport());

    }
}