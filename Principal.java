import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConexionExchangeRate conexion = new ConexionExchangeRate();
        ConversorMonedas conversor = new ConversorMonedas();

        // Obtenemos las tasas una sola vez con base USD
        Moneda moneda = conexion.obtenerMoneda("USD");
        Map<String, Double> tasas = moneda.conversion_rates();

        int opcion = 0;

        while (opcion != 7) {
            MenuConversor.exibirMenu();
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                String origen = "", destino = "";

                switch (opcion) {
                    case 1 -> { origen = "USD"; destino = "ARS"; }
                    case 2 -> { origen = "ARS"; destino = "USD"; }
                    case 3 -> { origen = "USD"; destino = "BRL"; }
                    case 4 -> { origen = "BRL"; destino = "USD"; }
                    case 5 -> { origen = "USD"; destino = "COP"; }
                    case 6 -> { origen = "COP"; destino = "USD"; }
                }

                double resultado = conversor.convertir(monto, origen, destino, tasas);
                System.out.printf("=> %.2f %s equivale a %.2f %s%n%n",
                        monto, origen, resultado, destino);
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
