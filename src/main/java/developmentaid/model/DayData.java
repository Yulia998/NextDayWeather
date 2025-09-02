package developmentaid.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class DayData {
    @SerializedName("maxtemp_c")
    private double maxTempC;
    @SerializedName("mintemp_c")
    private double minTempC;

    public DayData(double maxTempC, double minTempC) {
        this.maxTempC = maxTempC;
        this.minTempC = minTempC;
    }

    public double getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(double maxTempC) {
        this.maxTempC = maxTempC;
    }

    public double getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(double minTempC) {
        this.minTempC = minTempC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayData dayData = (DayData) o;
        return maxTempC == dayData.maxTempC &&
                minTempC == dayData.minTempC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTempC, minTempC);
    }

    @Override
    public String toString() {
        return "DayData{" +
                "minTempC=" + minTempC +
                ", maxTempC=" + maxTempC +
                "}";
    }
}
