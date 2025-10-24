/**
 * Temperature Converter
 * =====================
 * A comprehensive temperature conversion utility that converts between
 * Celsius, Fahrenheit, and Kelvin temperature scales.
 * 
 * Features:
 * - Converts between all three major temperature scales
 * - Provides formatted output with 2 decimal precision
 * - Includes physical constants and reference points
 * - Validates input ranges
 * 
 * Author: Hacktoberfest 2025 Contributor
 * Date: October 20, 2025
 */

public class TemperatureConverter {
    
    // Physical constants
    private static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    private static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;
    private static final double ABSOLUTE_ZERO_KELVIN = 0.0;
    
    /**
     * Converts Celsius to Fahrenheit
     * Formula: F = (C × 9/5) + 32
     * 
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    /**
     * Converts Celsius to Kelvin
     * Formula: K = C + 273.15
     * 
     * @param celsius Temperature in Celsius
     * @return Temperature in Kelvin
     */
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    /**
     * Converts Fahrenheit to Celsius
     * Formula: C = (F - 32) × 5/9
     * 
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    /**
     * Converts Fahrenheit to Kelvin
     * Formula: K = (F - 32) × 5/9 + 273.15
     * 
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Kelvin
     */
    public static double fahrenheitToKelvin(double fahrenheit) {
        return fahrenheitToCelsius(fahrenheit) + 273.15;
    }
    
    /**
     * Converts Kelvin to Celsius
     * Formula: C = K - 273.15
     * 
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Celsius
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    /**
     * Converts Kelvin to Fahrenheit
     * Formula: F = (K - 273.15) × 9/5 + 32
     * 
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Fahrenheit
     */
    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvin - 273.15);
    }
    
    /**
     * Checks if temperature is below absolute zero in Celsius
     * 
     * @param celsius Temperature in Celsius
     * @return true if valid, false if below absolute zero
     */
    public static boolean isValidCelsius(double celsius) {
        return celsius >= ABSOLUTE_ZERO_CELSIUS;
    }
    
    /**
     * Checks if temperature is below absolute zero in Kelvin
     * 
     * @param kelvin Temperature in Kelvin
     * @return true if valid, false if below absolute zero
     */
    public static boolean isValidKelvin(double kelvin) {
        return kelvin >= ABSOLUTE_ZERO_KELVIN;
    }
    
    /**
     * Formats temperature with 2 decimal places and unit
     * 
     * @param temperature The temperature value
     * @param unit The unit symbol (°C, °F, K)
     * @return Formatted temperature string
     */
    public static String formatTemperature(double temperature, String unit) {
        return String.format("%.2f %s", temperature, unit);
    }
    
    /**
     * Displays all conversions for a given Celsius temperature
     * 
     * @param celsius Temperature in Celsius
     */
    public static void displayAllConversions(double celsius) {
        if (!isValidCelsius(celsius)) {
            System.out.println("⚠️  Warning: Temperature is below absolute zero!");
            System.out.println("   Absolute zero = " + ABSOLUTE_ZERO_CELSIUS + " °C");
        }
        
        System.out.println("\n" + "─".repeat(50));
        System.out.println("Temperature: " + formatTemperature(celsius, "°C"));
        System.out.println("─".repeat(50));
        System.out.println("Celsius:    " + formatTemperature(celsius, "°C"));
        System.out.println("Fahrenheit: " + formatTemperature(celsiusToFahrenheit(celsius), "°F"));
        System.out.println("Kelvin:     " + formatTemperature(celsiusToKelvin(celsius), "K"));
        System.out.println("─".repeat(50));
    }
    
    /**
     * Main method - demonstrates temperature conversions
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("TEMPERATURE CONVERTER - Hacktoberfest 2025");
        System.out.println("=".repeat(60));
        
        // Important temperature reference points
        System.out.println("\n📊 Important Temperature Reference Points:\n");
        
        // Array of temperature values in Celsius
        double[] temps = {-273.15, -40, 0, 20, 37, 100, 150, 1000};
        String[] descriptions = {
            "Absolute Zero",
            "Celsius = Fahrenheit",
            "Water Freezing Point",
            "Room Temperature",
            "Human Body Temperature",
            "Water Boiling Point",
            "Hot Oven",
            "Lava Temperature"
        };
        
        // Display each reference point with all conversions
        for (int i = 0; i < temps.length; i++) {
            double celsius = temps[i];
            String description = descriptions[i];
            
            System.out.println("\n🌡️  " + description);
            System.out.printf("   Celsius:    %.2f °C%n", celsius);
            System.out.printf("   Fahrenheit: %.2f °F%n", celsiusToFahrenheit(celsius));
            System.out.printf("   Kelvin:     %.2f K%n", celsiusToKelvin(celsius));
        }
        
        // Example conversions
        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("EXAMPLE CONVERSIONS");
        System.out.println("=".repeat(60));
        
        // Test Case 1: Room temperature
        displayAllConversions(20);
        
        // Test Case 2: Body temperature
        displayAllConversions(37);
        
        // Test Case 3: Freezing point
        displayAllConversions(0);
        
        // Individual conversion examples
        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("USAGE EXAMPLES");
        System.out.println("=".repeat(60));
        
        System.out.println("\n// Convert 25°C to Fahrenheit:");
        System.out.println("double fahrenheit = TemperatureConverter.celsiusToFahrenheit(25);");
        System.out.println("Result: " + formatTemperature(celsiusToFahrenheit(25), "°F"));
        
        System.out.println("\n// Convert 98.6°F to Celsius:");
        System.out.println("double celsius = TemperatureConverter.fahrenheitToCelsius(98.6);");
        System.out.println("Result: " + formatTemperature(fahrenheitToCelsius(98.6), "°C"));
        
        System.out.println("\n// Convert 300K to Celsius:");
        System.out.println("double celsius = TemperatureConverter.kelvinToCelsius(300);");
        System.out.println("Result: " + formatTemperature(kelvinToCelsius(300), "°C"));
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ Temperature Converter Ready!");
        System.out.println("=".repeat(60));
    }
}
