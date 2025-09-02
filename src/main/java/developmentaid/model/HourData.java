package developmentaid.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class HourData {
    private String time;
    private int humidity;
    @SerializedName("wind_kph")
    private double windKph;
    @SerializedName("wind_dir")
    private String windDirection;

    public HourData(String time, int humidity, double windKph, String windDirection) {
        this.time = time;
        this.humidity = humidity;
        this.windKph = windKph;
        this.windDirection = windDirection;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourData hourData = (HourData) o;
        return Objects.equals(time, hourData.time) &&
                humidity == hourData.humidity &&
                windKph == hourData.windKph &&
                Objects.equals(windDirection, hourData.windDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, humidity, windKph, windDirection);
    }

    @Override
    public String toString() {
        return "HourData{Time=" + time +
                ", Humidity=" + humidity +
                ", WindKph=" + windKph +
                ", WindDirection:" + windDirection +
                "}";
    }
}
