//SANTIAGO



import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;


class DepreciationCar extends Car {
    private double originalPrice;
    private final double YEARLY_DEPRECIATION = 0.15;
    private final double AVERAGE_KM_PER_YEAR = 15000;

    public DepreciationCar(String company, String model, int year, double mileage, double originalPrice) {
        super(company, model, year, mileage);
        this.originalPrice = originalPrice;
    }

    public double calculateCurrentValue() {
        int carAge = LocalDate.now().getYear() - getYear();
        double depreciationFactor = Math.pow((1 - YEARLY_DEPRECIATION), carAge);

        double expectedMileage = carAge * AVERAGE_KM_PER_YEAR;
        double excessMileage = getMileage() - expectedMileage;

        if (excessMileage > 0) {
            double mileagePenalty = (excessMileage / 10000) * 0.02;
            depreciationFactor = Math.max(0.1, depreciationFactor - mileagePenalty);
        }

        return originalPrice * depreciationFactor;
    }

    public double getDepreciationAmount() {
        return originalPrice - calculateCurrentValue();
    }

    public double getDepreciationPercentage() {
        return (getDepreciationAmount() / originalPrice) * 100;
    }

    public String getDepreciationReport() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return "\n=== Depreciation Report ===\n" +
                "Car: " + getCompanyName() + " " + getModelName() + " (" + getYear() + ")\n" +
                "Original Price: " + formatter.format(originalPrice) + "\n" +
                "Current Value: " + formatter.format(calculateCurrentValue()) + "\n" +
                "Depreciation: " + formatter.format(getDepreciationAmount()) +
                " (" + String.format("%.1f", getDepreciationPercentage()) + "%)\n" +
                "Age: " + (LocalDate.now().getYear() - getYear()) + " years\n" +
                "Mileage: " + getMileage() + " km";
    }
}