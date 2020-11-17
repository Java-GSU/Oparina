package by.gsu.pms;

import static by.gsu.pms.GsonParser.*;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void  main(String[] args) {

        String API_KEY = "42c889ed863bbffa970b21fc35052b61";
        String LOCATION = "Kiev,ua";

        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units =imperial";

        try{

            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null){
                result.append(line);
            }

            rd.close();
            // System.out.println(result + "\n");

            Map<String, Object> respMap = jsonToMap (result.toString());

            Map<String, Object> mainMap = jsonToMap (respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap (respMap.get("wind").toString());
            Map<String, Object> cloudsMap = jsonToMap (respMap.get("clouds").toString());

            List<Object> weatherList = (List<Object>)respMap.get("weather");
            Map<String,Object> weatherInfo = (Map<String,Object>) weatherList.get(0);
            String weatherMain = String.valueOf(weatherInfo.get("main"));
            String weatherDescription = String.valueOf(weatherInfo.get("description"));
            String weatherIcon = String.valueOf(weatherInfo.get("icon"));

            Object city = respMap.get("name");
            Object cod_city = respMap.get("cod");

            Integer currentTemp = Integer.valueOf((int) Math.round((Double) mainMap.get("temp") - 273.0));
            Integer currentTempMin = Integer.valueOf((int) Math.round((Double) mainMap.get("temp_min") - 273.0));
            Integer currentTempMax = Integer.valueOf((int) Math.round((Double) mainMap.get("temp_max") - 273.0));

            Double humidity = Double.valueOf((Double) mainMap.get("humidity"));
            Integer pressure = Integer.valueOf((int) Math.round((Double) mainMap.get("pressure") / 1.333));

            Integer speedWind = Integer.valueOf((int) Math.round((Double) windMap.get("speed")));
            Double cloudy = Double.valueOf((Double) cloudsMap.get("all") );
            Integer deg = Integer.valueOf((int) Math.round((Double) windMap.get("deg") ));
            String angleWind = "";

            if (deg == 0){
                angleWind = "N";
            }
            else if (deg == 90){
                angleWind = "E";
            }
            else if (deg == 180){
                angleWind = "S";
            }
            else if (deg == 270){
                angleWind = "W";
            }
            else if (deg < 90){
                angleWind = "NE";
            }
            else if ((90 < deg) || (deg < 180)){
                angleWind = "SE";
            }
            else if ((180 < deg) || (deg < 270)){
                angleWind = "SW";
            }
            else if (deg > 270){
                angleWind = "NW";
            }


            String jsonString = new JSONObject()
                    .put("City", city)
                    .put("CodCity", cod_city)
                    .put("MainWeather", weatherMain)
                    .put("Description", weatherDescription)
                    .put("Icon", weatherIcon)
                    .put("CurrentTemperature", currentTemp)
                    .put("MinTemperature", currentTempMin)
                    .put("MaxTemperature", currentTempMax)
                    .put("Pressure", pressure)
                    .put("Humidity", humidity)
                    .put("WindSpeed", speedWind)
                    .put("WindAngle", angleWind)
                    .put("Cloudy", cloudy)
                    .toString();

            System.out.println(jsonString);

            try (FileWriter file = new FileWriter("src/by/gsu/pms/weather.json")) {
                file.write(jsonString);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}


