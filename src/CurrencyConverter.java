import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class CurrencyConverter {
    private static final String ACCESS_KEY = System.getenv("ACCESS_KEY");

    public double getExchangeRate(String monedaBase, String monedaFinal) {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + monedaBase + "?access_key=" + ACCESS_KEY;
        HttpClient client = HttpClient.newHttpClient();

        try {
            // Crear una solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(apiUrl))
                    .GET()
                    .build();

            // Enviar la solicitud y recibir una respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la solicitud fue exitosa
            if (response.statusCode() == 200) {

                // Parsear la respuesta JSON utilizando Gson
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

                // Verificar si la moneda objetivo está presente en la respuesta JSON
                JsonObject rates = jsonResponse.getAsJsonObject("rates");
                JsonElement elementoMonedaFinal = rates.get(monedaFinal);
                if (elementoMonedaFinal != null && !elementoMonedaFinal.isJsonNull()) {
                    return elementoMonedaFinal.getAsDouble();
                } else {
                    System.out.println("No se encontró la tasa de cambio para la moneda objetivo.");
                    return -1; // Retorna un valor negativo para mostrar un error en la consulta
                }
            } else {
                System.out.println("Error al realizar la solicitud: " + response.statusCode());
                return -1;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
