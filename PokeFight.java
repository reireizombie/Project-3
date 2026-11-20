 import java.net.URI;
 import java.net.URLEncoder;
 import java.net.http.HttpClient;
 import java.net.http.HttpRequest;
 import java.net.http.HttpResponse;
 import java.nio.charset.StandardCharsets;
 import org.json.JSONObject;
 import java.util.Iterator; // For iterating over JSON keys

public class PokeFight{
    
    public static String baseLineCheck (String pokemon) throws Exception {

        String urlString = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(urlString)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return "Status code 200, Working!";
        } else {
            return "STATUS CODE: " + response.statusCode() + "! FAIL!";
        }


    }

    public static void main(String[] args) throws Exception {
        System.out.println(baseLineCheck("wooper"));
    }
}