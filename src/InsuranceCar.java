//JEREZ

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


class InsuranceCar extends Car {
    private String insuranceProvider;
    private String policyNumber;
    private LocalDate expiryDate;
    private double annualPremium;

    public InsuranceCar(String company, String model, int year, double mileage) {
        super(company, model, year, mileage);
        this.insuranceProvider = "Not Set";
        this.policyNumber = "N/A";
        this.expiryDate = LocalDate.now().plusYears(1);
        this.annualPremium = calculatePremium();
    }

    public void setInsurance(String provider, String policyNum, LocalDate expiry) {
        this.insuranceProvider = provider;
        this.policyNumber = policyNum;
        this.expiryDate = expiry;
    }

    public double calculatePremium() {
        double basePremium = 1000.0;
        int carAge = LocalDate.now().getYear() - getYear();
        double ageFactor = 1.0 - (carAge * 0.05);

        double mileageFactor = 1.0;
        if (getMileage() > 100000) {
            mileageFactor = 1.3;
        } else if (getMileage() > 50000) {
            mileageFactor = 1.1;
        }

        return basePremium * ageFactor * mileageFactor;
    }

    public long daysUntilExpiry() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }

    public String getInsuranceReport() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return "\n=== Insurance Report ===\n" +
                "Car: " + getCompanyName() + " " + getModelName() + "\n" +
                "Provider: " + insuranceProvider + "\n" +
                "Policy Number: " + policyNumber + "\n" +
                "Expiry Date: " + expiryDate + "\n" +
                "Days Until Expiry: " + daysUntilExpiry() + " days\n" +
                "Annual Premium: " + formatter.format(calculatePremium()) + "\n" +
                (daysUntilExpiry() < 30 ? "WARNING: Insurance expiring soon!" : "Insurance valid");
    }
}