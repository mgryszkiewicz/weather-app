
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
        System.out.println(api.getWeatherByCity("Warszawa", "standard", "pl"));
    }
}
