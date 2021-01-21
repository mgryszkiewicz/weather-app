package Weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.nio.IntBuffer;
import java.util.Date;

public abstract class Weather
{
    //Time
    Date currentTime;

    //Description and Ico Id
    WeatherInfo weatherInfo;

    //Temperature in selected Units(K, C, F)
    double dewTemperature; //Temperatura ponizej ktorej tworzy sie rosa

    //Preassure in hP
    int pressure;

    //Cloud
    int cloudiness; //Cloudiness in %

    int humidity; //Humidity in %

    //UV index
    double uvIndex;


    //Wind speed in selected Units (default: metre/sec, metric: metre/sec, imperial: miles/hou)
    double windSpeed;
    double windGust;
    int windDeg; //Wind direction, degrees

    public Weather()
    {
        currentTime = new Date();

        weatherInfo = new WeatherInfo();

        dewTemperature = 0.0;

        pressure = 0;

        cloudiness = 0;

        humidity = 0;

        uvIndex = 0.0;

        windSpeed = 0.0;
        windGust = 0.0;

        windDeg = 0;

    }

    public void uppdate(JSONObject current)
    {
        currentTime = new Date(Long.valueOf(current.get("dt").toString()) * 1000);

        weatherInfo.uppdate((JSONArray) current.get("weather"));

        dewTemperature = Double.valueOf(current.get("dew_point").toString());

        pressure = Integer.valueOf(current.get("pressure").toString());

        cloudiness = Integer.valueOf(current.get("clouds").toString());

        humidity = Integer.valueOf(current.get("humidity").toString());

        uvIndex = Double.valueOf(current.get("uvi").toString());

        windSpeed = Double.valueOf(current.get("wind_speed").toString());

        if(null != current.get("wind_gust"))
        {
            windGust = Double.valueOf(current.get("wind_gust").toString());
        }

        windDeg = Integer.valueOf(current.get("wind_deg").toString());

    }

    @Override
    public String toString() {
        return "Weather{" +
                "currentTime=" + currentTime +
                ", weatherInfo=" + weatherInfo +
                ", dewTemperature=" + dewTemperature +
                ", pressure=" + pressure +
                ", cloudiness=" + cloudiness +
                ", humidity=" + humidity +
                ", uvIndex=" + uvIndex +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", windDeg=" + windDeg +
                '}';
    }

}
