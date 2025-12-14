//JEREZ


class FuelCar extends Car {
    private double fuelCapacity;
    private double currentFuelLevel;
    private double totalFuelConsumed;
    private double totalDistanceTraveled;

    public FuelCar(String company, String model, int year, double mileage, double fuelCapacity) {
        super(company, model, year, mileage);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = fuelCapacity;
        this.totalFuelConsumed = 0.0;
        this.totalDistanceTraveled = 0.0;
    }

    public void refuel(double liters) {
        if (currentFuelLevel + liters > fuelCapacity) {
            currentFuelLevel = fuelCapacity;
        } else {
            currentFuelLevel += liters;
        }
        totalFuelConsumed += liters;
    }

    public void drive(double distance) {
        double fuelNeeded = distance / 15; // Assume 15 km/L
        if (fuelNeeded <= currentFuelLevel) {
            currentFuelLevel -= fuelNeeded;
            totalDistanceTraveled += distance;
            updateMileage(getMileage() + distance);
        } else {
            System.out.println("Not enough fuel!");
        }
    }

    public double calculateEfficiency() {
        if (totalFuelConsumed == 0) return 0;
        return totalDistanceTraveled / totalFuelConsumed;
    }

    public double estimateRange() {
        return currentFuelLevel * calculateEfficiency();
    }

    public String getFuelReport() {
        return "\n=== Fuel Efficiency Report ===\n" +
                "Car: " + getCompanyName() + " " + getModelName() + "\n" +
                "Fuel Capacity: " + fuelCapacity + " L\n" +
                "Current Fuel: " + String.format("%.2f", currentFuelLevel) + " L\n" +
                "Total Fuel Consumed: " + String.format("%.2f", totalFuelConsumed) + " L\n" +
                "Total Distance: " + String.format("%.2f", totalDistanceTraveled) + " km\n" +
                "Average Efficiency: " + String.format("%.2f", calculateEfficiency()) + " km/L\n" +
                "Estimated Range: " + String.format("%.2f", estimateRange()) + " km";
    }
}