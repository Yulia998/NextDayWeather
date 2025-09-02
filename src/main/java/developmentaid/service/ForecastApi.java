package developmentaid.service;

import developmentaid.model.Forecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApi {
    @GET("v1/forecast.json")
    Call<Forecast> getForecastByQDate(@Query("key") String key, @Query("q") String q, @Query("dt") String date);
}
