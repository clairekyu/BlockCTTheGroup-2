class Car {
    // Private instance variables (Encapsulation)
    private String company_name;
    private String model_name;
    private int year;
    private double mileage;

    // Constructor
    public Car(String company_name, String model_name, int year, double mileage) {
        this.company_name = company_name;
        this.model_name = model_name;
        this.year = year;
        this.mileage = mileage;
    }

    // Getter and Setter for company_name
    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    // Getter and Setter for model_name
    public String getModelName() {
        return model_name;
    }

    public void setModelName(String model_name) {
        this.model_name = model_name;
    }

    // Getter and Setter for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter ONLY for mileage (read-only access)
    public double getMileage() {
        return mileage;
    }

    // Protected method to update mileage (used internally)
    protected void updateMileage(double newMileage) {
        if (newMileage >= this.mileage) {
            this.mileage = newMileage;
        }
    }

    @Override
    public String toString() {
        return "Car{Company='" + company_name + "', Model='" + model_name +
                "', Year=" + year + ", Mileage=" + mileage + " km}";
    }
}
