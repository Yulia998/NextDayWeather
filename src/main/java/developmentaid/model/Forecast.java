package developmentaid.model;

import java.util.Objects;

public class Forecast {
    private ForecastData forecast;
    private Location location;

    public Forecast(ForecastData forecast, Location location) {
        this.forecast = forecast;
        this.location = location;
    }

    public ForecastData getForecast() {
        return forecast;
    }

    public void setForecast(ForecastData forecast) {
        this.forecast = forecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecastObj = (Forecast) o;
        return Objects.equals(forecast, forecastObj.forecast) &&
                Objects.equals(location, forecastObj.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forecast, location);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "forecast=" + forecast +
                ", location=" + location +
                "}";
    }
}
