package developmentaid.model;

import java.util.List;
import java.util.Objects;

public class ForecastDayData {
    private String date;
    private DayData day;
    private List<HourData> hour;

    public ForecastDayData(String date, DayData day, List<HourData> hour) {
        this.date = date;
        this.day = day;
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayData getDay() {
        return day;
    }

    public void setDay(DayData day) {
        this.day = day;
    }

    public List<HourData> getHour() {
        return hour;
    }

    public void setHour(List<HourData> hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForecastDayData forecastDayData = (ForecastDayData) o;
        return Objects.equals(date, forecastDayData.date) &&
                Objects.equals(day, forecastDayData.day) &&
                Objects.equals(hour, forecastDayData.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, day, hour);
    }

    @Override
    public String toString() {
        return "ForecastDayData{" +
                "Date=" + date +
                ", Day=" + day +
                ", Hours=" + hour +
                "}";
    }
}
