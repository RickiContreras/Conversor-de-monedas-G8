import java.util.Map;

public class ConversorMonedas {
        public double convertir(double monto, String monedaOrigen, String monedaDestino,
                                Map<String, Double> tasas) {
            double tasaOrigen = tasas.get(monedaOrigen);
            double tasaDestino = tasas.get(monedaDestino);

            double valorEnBase = monto / tasaOrigen;
            return valorEnBase * tasaDestino;
        }
}
