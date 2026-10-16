package lab2;

public class Temperature {
    private final double kelvin;

    
    private Temperature(double kelvin) {
        this.kelvin = kelvin;
    }

    
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius + 273.15);
    }

    
    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5 / 9 + 273.15);
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25.0);
        Temperature t2 = Temperature.fromFahrenheit(98.6);

        System.out.printf("t1 in Fahrenheit: %.2f°F%n", t1.getFahrenheit());
        System.out.printf("t2 in Celsius: %.2f°C%n", t2.getCelsius());
    }
}