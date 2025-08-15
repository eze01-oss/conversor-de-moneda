package com.conversor;

public class ConversorMoneda {
    public static double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        double tasaOrigen = ExchangeRateAPI.getTasaCambio(monedaOrigen);
        double tasaDestino = ExchangeRateAPI.getTasaCambio(monedaDestino);

        if (tasaOrigen == -1 || tasaDestino == -1) {
            return -1; // Error
        }

        // Convertir a USD primero y luego a la moneda destino
        double enUsd = cantidad / tasaOrigen;
        return enUsd * tasaDestino;
    }
}