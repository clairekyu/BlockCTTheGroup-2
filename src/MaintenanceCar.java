import java.util.*;
import java.text.NumberFormat;

class MaintenanceCar extends Car {
    private ArrayList<String> maintenanceHistory;
    private double totalMaintenanceCost;
    private String lastServiceDate;

    public MaintenanceCar(String company, String model, int year, double mileage) {
        super(company, model, year, mileage);
        this.maintenanceHistory = new ArrayList<>();
        this.totalMaintenanceCost = 0.0;
        this.lastServiceDate = "Never";
    }

    // Add maintenance record (Abstraction - hides internal list management)
    public void addMaintenance(String service, double cost, String date) {
        String record = date + " - " + service + " ($" + cost + ")";
        maintenanceHistory.add(record);
        totalMaintenanceCost += cost;
        lastServiceDate = date;
    }

    // Calculate service recommendation based on mileage (Abstraction)
    public String getServiceRecommendation() {
        double mileage = getMileage();
        if (mileage >= 100000) {
            return "URGENT: Major service required!";
        } else if (mileage >= 50000) {
            return "Schedule comprehensive checkup soon";
        } else if (mileage >= 10000) {
            return "Regular oil change recommended";
        }
        return "No service needed yet";
    }

    public void recordTrip(double distanceTraveled) {
        updateMileage(getMileage() + distanceTraveled);
    }

    public String getMaintenanceReport() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return "\n=== Maintenance Report ===\n" +
                "Car: " + getCompanyName() + " " + getModelName() + "\n" +
                "Current Mileage: " + getMileage() + " km\n" +
                "Last Service: " + lastServiceDate + "\n" +
                "Total Maintenance Cost: " + formatter.format(totalMaintenanceCost) + "\n" +
                "Service Recommendation: " + getServiceRecommendation() + "\n" +
                "History: " + (maintenanceHistory.isEmpty() ? "None" :
                "\n  " + String.join("\n  ", maintenanceHistory));
    }
}