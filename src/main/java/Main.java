
import Weather.Current;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        //Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
//        JSONArray daily_weather = (JSONArray) api.getWeatherByCity("Warszawa", "standard", "pl").get("daily");
//        JSONObject day1 = (JSONObject) daily_weather.get(1);
//        System.out.println(day1.toString());
        //JSONObject Warszawa_pogoda = api.getWeatherByCity("Warszawa", "metric", "pl");
//        JSONObject Warszawa_pogoda_main = (JSONObject) Warszawa_pogoda.get("main");
        //System.out.println(Warszawa_pogoda.get("timezone").toString());
        //if(null == Warszawa_pogoda.get("current.uvi"))
            //System.out.println("alala");
//        System.out.println(Double.parseDouble(Warszawa_pogoda_main.get("temp").toString()));

//        JSONObject current_weather = api.getCurrentWeather("Warszawa", "standard", "pl");
//        System.out.println(current_weather.toJSONString());

        //System.out.println(Warszawa_pogoda.toJSONString());

        //System.out.println();

        //Current current = new Current();
        //System.out.println(current);

        //current.uppdate((JSONObject)Warszawa_pogoda.get("current"));

        //System.out.println(current);

        WeatherAnalizer weatherAnalizer = new WeatherAnalizer();

        weatherAnalizer.getCurrentWeather("Warsaw", "metric", "pl");

        System.out.println(weatherAnalizer.currentWeather.rain);
    }
}
