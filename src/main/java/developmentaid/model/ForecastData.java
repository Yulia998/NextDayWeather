package developmentaid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ForecastData {
    @SerializedName("forecastday")
    private List<ForecastDayData> forecastDay;

    public ForecastData(List<ForecastDayData> forecastDay) {
        this.forecastDay = forecastDay;
    }

    public List<ForecastDayData> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(List<ForecastDayData> forecastDay) {
        this.forecastDay = forecastDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForecastData forecastData = (ForecastData) o;
        return Objects.equals(forecastDay, forecastData.forecastDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forecastDay);
    }

    @Override
    public String toString() {
        return "ForecastData{forecastDay=" + forecastDay + "}";
    }
}
