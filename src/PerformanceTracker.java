import java.util.*;
import java.text.NumberFormat;


class PerformanceTracker extends Employee {
    private int performanceScore; // 0-100
    private ArrayList<String> achievements;

    public PerformanceTracker(int id, String name, double salary) {
        super(id, name, salary);
        this.performanceScore = 50; // Default score
        this.achievements = new ArrayList<>();
    }

    // Calculate bonus based on performance (Abstraction - hides complex calculation)
    public String calculateBonus() {
        double rawSalary = getRawSalary();
        double bonusPercentage = performanceScore / 100.0 * 0.2; // Max 20% bonus
        double bonus = rawSalary * bonusPercentage;

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(bonus);
    }

    public void addAchievement(String achievement) {
        achievements.add(achievement);
        performanceScore = Math.min(100, performanceScore + 5); // Increase score
    }

    public void setPerformanceScore(int score) {
        this.performanceScore = Math.max(0, Math.min(100, score));
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public ArrayList<String> getAchievements() {
        return new ArrayList<>(achievements); // Return copy for encapsulation
    }

    public String getPerformanceReport() {
        return "\n=== Performance Report ===\n" +
                "Employee: " + getEmployeeName() + "\n" +
                "Performance Score: " + performanceScore + "/100\n" +
                "Estimated Bonus: " + calculateBonus() + "\n" +
                "Achievements: " + (achievements.isEmpty() ? "None" : achievements);
    }
}