import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionExchangeRate {
        public Moneda obtenerMoneda(String conversion_rates){
            URI direccion = URI.create(
                    "https://v6.exchangerate-api.com/v6/33dd44b134eac13b74b4d5f8/latest/"+conversion_rates+"/");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

            HttpResponse<String> response = null;
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new Gson().fromJson(response.body(), Moneda.class);
    }
}
