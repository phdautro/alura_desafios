import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIservice {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/f2ab3267952df0b15e90c8c8/latest/USD";

    public static JsonObject getExchangeRates() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jsonParser = new JsonParser();
        JsonElement root = jsonParser.parse(new InputStreamReader((request.getInputStream())));
        return root.getAsJsonObject();
    }
}

