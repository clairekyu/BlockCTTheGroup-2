//TUMACA

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;


class SalaryEmployee extends Employee {
    private ArrayList<String> salaryHistory;
    private LocalDate lastRaiseDate;

    public SalaryEmployee(int id, String name, double salary) {
        super(id, name, salary);
        this.salaryHistory = new ArrayList<>();
        this.salaryHistory.add(LocalDate.now() + " - Initial Salary: $" + salary);
        this.lastRaiseDate = LocalDate.now();
    }

    public String giveSalaryRaise(double newSalary, String reason) {
        double oldSalary = getRawSalary();
        double raiseAmount = newSalary - oldSalary;
        double raisePercentage = (raiseAmount / oldSalary) * 100;

        salaryHistory.add(LocalDate.now() + " - Raise: $" + oldSalary + " → $" +
                newSalary + " (+" + String.format("%.2f", raisePercentage) + "%) - " + reason);
        lastRaiseDate = LocalDate.now();

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return "Salary increased by " + String.format("%.2f", raisePercentage) + "% - " +
                formatter.format(raiseAmount) + " raise";
    }

    public String getSalaryGrowth() {
        String firstEntry = salaryHistory.get(0);
        double firstSalary = extractSalary(firstEntry);
        double currentSalary = getRawSalary();
        double totalGrowth = ((currentSalary - firstSalary) / firstSalary) * 100;
        return String.format("%.2f", totalGrowth) + "% growth since hire";
    }

    private double extractSalary(String entry) {
        // Simple extraction - in real code would be more robust
        return 50000; // Placeholder
    }

    public String getSalaryReport() {
        return "\n=== Salary History Report ===\n" +
                "Employee: " + getEmployeeName() + "\n" +
                "Current Salary: " + getEmployeeSalary() + "\n" +
                "Last Raise: " + lastRaiseDate + "\n" +
                "History:\n  " + String.join("\n  ", salaryHistory);
    }
}