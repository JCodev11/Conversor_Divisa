import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        System.out.println(".....................................................................................................");
        System.out.println("Bienvenido al Sistema de Conversion de Divisas:\nTuDivisa.com");
        System.out.println(".....................................................................................................");
        System.out.println("");

        boolean appEnEjecucion = true;
        while (appEnEjecucion) {

            // Menú para seleccionar la Divisa Base
            System.out.println("Seleccione la Divisa base:");
            System.out.println("");
            System.out.println("+-----------------------------+");
            System.out.println("|1. ARS - Peso argentino      |");
            System.out.println("+-----------------------------+");
            System.out.println("|2. BOB - Boliviano boliviano |");
            System.out.println("+-----------------------------+");
            System.out.println("|3. BRL - Real brasileño      |");
            System.out.println("+-----------------------------+");
            System.out.println("|4. CLP - Peso chileno        |");
            System.out.println("+-----------------------------+");
            System.out.println("|5. COP - Peso colombiano     |");
            System.out.println("+-----------------------------+");
            System.out.println("|6. USD - Dólar estadounidense|");
            System.out.println("+-----------------------------+");
            System.out.println("");
            System.out.print("Ingrese el número correspondiente a la Divisa base: ");

            int opcion = scanner.nextInt();
            String monedaBase;

            switch (opcion) {
                case 1:
                    monedaBase = "ARS";
                    break;
                case 2:
                    monedaBase = "BOB";
                    break;
                case 3:
                    monedaBase = "BRL";
                    break;
                case 4:
                    monedaBase = "CLP";
                    break;
                case 5:
                    monedaBase = "COP";
                    break;
                case 6:
                    monedaBase = "USD";
                    break;
                default:
                    System.out.println("Opción inválida");
                    continue;
            }
            System.out.println(".....................................................................................................................");
            System.out.println("");

            // Menú para seleccionar la Divisa Final
            System.out.println("Seleccione la Divisa a obtener:");
            System.out.println("");
            System.out.println("+-----------------------------+");
            System.out.println("|1. ARS - Peso argentino      |");
            System.out.println("+-----------------------------+");
            System.out.println("|2. BOB - Boliviano boliviano |");
            System.out.println("+-----------------------------+");
            System.out.println("|3. BRL - Real brasileño      |");
            System.out.println("+-----------------------------+");
            System.out.println("|4. CLP - Peso chileno        |");
            System.out.println("+-----------------------------+");
            System.out.println("|5. COP - Peso colombiano     |");
            System.out.println("+-----------------------------+");
            System.out.println("|6. USD - Dólar estadounidense|");
            System.out.println("+-----------------------------+");
            System.out.println("");
            System.out.print("Ingrese el número correspondiente a la divisa a obtener: ");

            int opcion2 = scanner.nextInt();
            String monedaFinal;

            switch (opcion2) {
                case 1:
                    monedaFinal = "ARS";
                    break;
                case 2:
                    monedaFinal = "BOB";
                    break;
                case 3:
                    monedaFinal = "BRL";
                    break;
                case 4:
                    monedaFinal = "CLP";
                    break;
                case 5:
                    monedaFinal = "COP";
                    break;
                case 6:
                    monedaFinal = "USD";
                    break;
                default:
                    System.out.println("Opción inválida");
                    continue;
            }

            System.out.println("........................................................................................................................");
            System.out.println("");

            // Ingrese el valor a convertir
            System.out.print("Ingrese el valor a convertir en " + monedaBase + ": ");
            double valor = scanner.nextDouble();

            // Obtener la tasa de cambio
            double exchangeRate = currencyConverter.getExchangeRate(monedaBase, monedaFinal);

            if (exchangeRate != -1) {
                // Convertir moneda
                double convertedValue = valor * exchangeRate;
                System.out.println("...................................................................................................................");


                // Mostrar resultado
                System.out.println(valor + " " + monedaBase + " = " + convertedValue + " " + monedaFinal);
            } else {
                System.out.println("Error al obtener la tasa de cambio.");
            }
            System.out.println("");

            // Preguntar al usuario si desea continuar convirtiendo Divisas
            System.out.print("¿Desea continuar convirtiendo Divisas? (s/n): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                appEnEjecucion = false;
            }
        }
    }
}
