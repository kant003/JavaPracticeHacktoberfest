package Cosas;

import java.util.*;

public class Uno {
	static Scanner sc = new Scanner(System.in);

	// Celcius a Fahrenheit
	static double Celcius_a_Fahrenheit(double Celcius) {
		double Fahrenheit = (Celcius * 9 / 5) + 32;
		return Fahrenheit;
	}

	// Celcius a Kelvin
	static double Celcius_a_Kelvin(double Celcius) {
		double Kelvin = Celcius + 273.15;
		return Kelvin;
	}

	// Fahrenheit a Celcius
	static double Fahrenheit_a_Celcius(double Fahrenheit) {
		double Celcius = (Fahrenheit - 32) * 5 / 9;
		return Celcius;
	}

	// Fahrenheit a Kelvin
	static double Fahrenheit_a_Kelvin(double Fahrenheit) {
		double Kelvin = (Fahrenheit - 32) * 5 / 9 + 273.15;
		return Kelvin;
	}

	// Kelvin a Celcius
	static double Kelvin_a_Celcius(double Kelvin) {
		double Celcius = Kelvin - 273.15;
		return Celcius;
	}

	// Kelvin a Fahrenheit
	static double Kelvin_a_Fahrenheit(double Kelvin) {
		double Fahrenheit = (Kelvin - 273.15) * 9 / 5 + 32;
		return Fahrenheit;
	}

	// Lee el Valor de Temperatura
	static double Input_Temperatura(String Temperatura) {
		System.out.println(" Valor de " + Temperatura + ":");
		double val = sc.nextDouble();
		return val;
	}
	
	// Print nuevo Valor de Temperatura
	static void Output_Temperatura(double Valor, String Temperatura) {
		char SoloLetra = Temperatura.charAt(0);
		System.out.println(" En " + Temperatura + " Da: " + Valor +"º"+ SoloLetra);
		
		
	}

	// Metodo
	public static void main(String args[]) {
		
		System.out.println(" 1. Para Celcius a Fahrenheit\n 2. Para Celcius a Kelvin\n"
				+ " 3. Para Fahrenheit a Celcius\n 4. Para Fahrenheit a Kelvin\n"
				+ " 5. Para Kelvin a Celcius\n 6. Para Kelvin a Fahrenheit\n 7. Exit");
		do {
			System.out.println("\n Elige Cálculo: ");
			int Elige_Temperatura = sc.nextInt();
			double Elige_Número = 0;
			switch (Elige_Temperatura) {
			case 1:
				Elige_Número = Input_Temperatura("Celcius");
				Output_Temperatura(Celcius_a_Fahrenheit(Elige_Número), "Fahrenheit");
				break;
			case 2:
				Elige_Número = Input_Temperatura("Celcius");
				Output_Temperatura(Celcius_a_Kelvin(Elige_Número), "Kelvin");
				break;
			case 3:
				Elige_Número = Input_Temperatura("Fahrenheit");
				Output_Temperatura(Fahrenheit_a_Celcius(Elige_Número), "Celcius");
				break;
			case 4:
				Elige_Número = Input_Temperatura("Fahrenheit");
				Output_Temperatura(Fahrenheit_a_Kelvin(Elige_Número), "Kelvin");
				break;
			case 5:
				Elige_Número = Input_Temperatura("Kelvin");
				Output_Temperatura(Kelvin_a_Celcius(Elige_Número), "Celcius");
				break;
			case 6:
				Elige_Número = Input_Temperatura("Kelvin");
				Output_Temperatura(Kelvin_a_Fahrenheit(Elige_Número), "Fahrenheit");
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
			}
		} while (true);
	}
}
