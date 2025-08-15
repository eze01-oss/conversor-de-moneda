package com.conversor;

public class Main {
    public static void main(String[] args) {
        int opcionPrincipal, opcionDestino;
        String monedaOrigen, monedaDestino;
        double cantidad, resultado;

        do {
            Menu.mostrarMenuPrincipal();
            opcionPrincipal = Menu.obtenerOpcion();

            if (opcionPrincipal >= 1 && opcionPrincipal <= 3) {
                monedaOrigen = Menu.codigoMonedaOrigen(opcionPrincipal);

                do {
                    Menu.mostrarMenuDestino(monedaOrigen);
                    opcionDestino = Menu.obtenerOpcion();

                    if (opcionDestino >= 1 && opcionDestino <= 5) {
                        monedaDestino = Menu.codigoMonedaDestino(opcionDestino);

                        if (!monedaOrigen.equals(monedaDestino)) {
                            cantidad = Menu.obtenerCantidad();
                            resultado = ConversorMoneda.convertir(cantidad, monedaOrigen, monedaDestino);

                            if (resultado != -1) {
                                Menu.mostrarResultado(cantidad, monedaOrigen, resultado, monedaDestino);
                            } else {
                                System.out.println("Error en la conversión. Intente nuevamente.");
                            }
                        } else {
                            System.out.println("¡No puede convertir la misma moneda!");
                        }
                    }
                } while (opcionDestino != 6);
            }
        } while (opcionPrincipal != 4);

        System.out.println("¡Gracias por usar el conversor!");
    }
}