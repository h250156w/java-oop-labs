package lab11;

interface FineStrategy {
    double calculateFine(int daysOverdue);
}

class StandardFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 1.50;
    }
}

class StudentFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 0.50;
    }
}

class FineCalculator {
    private FineStrategy strategy;

    public FineCalculator(FineStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FineStrategy strategy) {
        this.strategy = strategy;
    }

    public double compute(int days) {
        return strategy.calculateFine(days);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        FineCalculator calculator = new FineCalculator(new StandardFineStrategy());
        System.out.printf("Standard Fine for 5 days: $%.2f%n", calculator.compute(5));

        calculator.setStrategy(new StudentFineStrategy());
        System.out.printf("Student Fine for 5 days: $%.2f%n", calculator.compute(5));
    }
}
