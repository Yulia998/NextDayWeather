package developmentaid.service;

import com.google.gson.Gson;
import developmentaid.config.AppProperties;
import developmentaid.model.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;

public class ForecastService {
    public static final String URL = "https://api.weatherapi.com/";

    public LinkedHashMap<String, LinkedHashMap<String, String>> getForecastByQueryAndDate(String q, LocalDate date) {
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        ForecastApi weatherApi = retrofit.create(ForecastApi.class);
        Call<Forecast> call = weatherApi.getForecastByQDate(AppProperties.apiKey, q, date.toString());
        try {
            Response<Forecast> response = call.execute();
            if (response.isSuccessful()) {
                Forecast forecast = response.body();
                if (forecast != null) {
                    return formatDataByLocationFieldsDates(forecast);
                }
            } else {
                handleError(response);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while getting response. " + e);
        }
        return null;
    }

    private LinkedHashMap<String, LinkedHashMap<String, String>> formatDataByLocationFieldsDates(Forecast forecast) {
        LinkedHashMap<String, LinkedHashMap<String, String>> result = new LinkedHashMap<>();
        LinkedHashMap<String, String> city = new LinkedHashMap<>();
        LinkedHashMap<String, String> maxTemp = new LinkedHashMap<>();
        LinkedHashMap<String, String> minTemp = new LinkedHashMap<>();
        LinkedHashMap<String, String> humidity = new LinkedHashMap<>();
        LinkedHashMap<String, String> windSpeed = new LinkedHashMap<>();
        LinkedHashMap<String, String> windDirection = new LinkedHashMap<>();
        city.put("value", forecast.getLocation().getName());
        for (ForecastDayData dayData : forecast.getForecast().getForecastDay()) {
            minTemp.put(dayData.getDate(), String.valueOf(dayData.getDay().getMinTempC()));
            maxTemp.put(dayData.getDate(), String.valueOf(dayData.getDay().getMaxTempC()));
            for (HourData hourData : dayData.getHour()) {
                humidity.put(hourData.getTime(), String.valueOf(hourData.getHumidity()));
                windSpeed.put(hourData.getTime(), String.valueOf(hourData.getWindKph()));
                windDirection.put(hourData.getTime(), String.valueOf(hourData.getWindDirection()));
            }
        }
        result.put("City", city);
        result.put("Minimum Temperature (C)", minTemp);
        result.put("Maximum Temperature (C)", maxTemp);
        result.put("Humidity (%)", humidity);
        result.put("Wind Speed (kph)", windSpeed);
        result.put("Wind Direction", windDirection);
        return result;
    }

    private void handleError(Response<Forecast> response) throws IOException {
        Gson gson = new Gson();
        try (ResponseBody errorBody = response.errorBody()) {
            if (errorBody != null) {
                ErrorResponse errorResponse = gson.fromJson(errorBody.string(), ErrorResponse.class);
                System.out.println("Got bad response. " + errorResponse);
            }
        }
    }
}
