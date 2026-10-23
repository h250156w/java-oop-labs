package lab3;

public class Temperature {
    private double kelvin;

    public Temperature(double kelvin) {
        setKelvin(kelvin);
    }

    public void setKelvin(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero.");
        }
        this.kelvin = kelvin;
    }

    public double getKelvin() { return kelvin; }
    public double getCelsius() { return kelvin - 273.15; }
    public double getFahrenheit() { return (kelvin - 273.15) * 9 / 5 + 32; }

    public static void main(String[] args) {
        Temperature t = new Temperature(300.15);
        System.out.printf("Internal Kelvin: %.2f K%n", t.getKelvin());
        System.out.printf("Exposed Celsius: %.2f °C%n", t.getCelsius());
        System.out.printf("Exposed Fahrenheit: %.2f °F%n", t.getFahrenheit());
    }
}