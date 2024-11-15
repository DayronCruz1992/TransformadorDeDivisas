import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public double buscarMoneda (String base_code, String target_code){
        String apikey = "365729b958e4815327aad1d9";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + base_code + "/" + target_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();

        }catch (Exception e){
            throw new RuntimeException("Moneda no encontrada");
        }
        //String direccion = "https://v6.exchangerate-api.com/v6/365729b958e4815327aad1d9/latest/USD"+busqueda;
    }
}
