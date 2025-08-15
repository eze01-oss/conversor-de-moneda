package com.conversor;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal() {
        System.out.println("\n***********************************");
        System.out.println("CONVERSOR DE MONEDAS - ALURA");
        System.out.println("1. Convertir de ARS (Peso Argentino)");
        System.out.println("2. Convertir de USD (Dólar Estadounidense)");
        System.out.println("3. Convertir de BRL (Real Brasileño)");
        System.out.println("4. Salir");
        System.out.println("***********************************");
    }

    public static void mostrarMenuDestino(String monedaOrigen) {
        System.out.println("\n***********************************");
        System.out.println("CONVIRTIENDO DESDE " + monedaOrigen);
        System.out.println("1. ARS (Peso Argentino)");
        System.out.println("2. USD (Dólar Estadounidense)");
        System.out.println("3. BRL (Real Brasileño)");
        System.out.println("4. COP (Peso Colombiano)");
        System.out.println("5. CLP (Peso Chileno)");
        System.out.println("6. Volver al menú principal");
        System.out.println("***********************************");
    }

    public static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public static double obtenerCantidad() {
        System.out.print("Ingrese cantidad a convertir: ");
        return scanner.nextDouble();
    }

    public static String codigoMonedaOrigen(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "BRL";
            default -> "";
        };
    }

    public static String codigoMonedaDestino(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "BRL";
            case 4 -> "COP";
            case 5 -> "CLP";
            default -> "";
        };
    }

    public static void mostrarResultado(double cantidad, String monedaOrigen, double resultado, String monedaDestino) {
        System.out.printf("\n%.2f %s = %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
        System.out.println("-----------------------------------");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine(); // Limpiar buffer
        scanner.nextLine(); // Esperar Enter
    }
}