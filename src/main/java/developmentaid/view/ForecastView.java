package developmentaid.view;

import java.util.*;

public class ForecastView {
    public void generateTableByLocationFieldsDates(List<LinkedHashMap<String, LinkedHashMap<String, String>>> forecasts) {
        if (forecasts.isEmpty()) {
            return;
        }
        String dayPattern = "\\d{4}-\\d{2}-\\d{2}";
        String hourPattern = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
        int cityLength = 15;
        int fieldLength = 30;
        int hourLength = 5;
        String dayFormat = " %-89s %-10s %-88s |";
        StringBuilder output = new StringBuilder();
        output.append(String.format("| %-" + cityLength + "s | %-" + fieldLength + "s |", "", ""));
        Set<String> days = forecasts.get(0).get("Minimum Temperature (C)").keySet();
        days.forEach(day -> output.append(String.format(dayFormat, "", day, "")));
        String lineSeparator = "-".repeat(output.length()) + "\n";
        String lineDateSeparator = "-".repeat(output.length() - cityLength - fieldLength - 10);
        output.append(String.format("%n| %-" + cityLength + "s | %-" + fieldLength + "s | %s |%n", "", "", lineDateSeparator));
        output.insert(0, lineSeparator);
        output.append(String.format("| %-" + cityLength + "s | %-" + fieldLength + "s |", "CITY", "CHARACTERISTIC"));
        for (String hour : forecasts.get(0).get("Humidity (%)").keySet()) {
            output.append(String.format(" %-" + hourLength + "s |", hour.split(" ")[1]));
        }
        output.append("\n").append(lineSeparator);
        for (Map<String, LinkedHashMap<String, String>> forecast : forecasts) {
            output.append(String.format("| %-" + cityLength + "s |", forecast.get("City").get("value")));
            int elementN = 0;
            for (Map.Entry<String, LinkedHashMap<String, String>> entry : forecast.entrySet()) {
                elementN++;
                String firstKey = entry.getValue().keySet().iterator().next();
                if (!firstKey.matches(dayPattern) && !firstKey.matches(hourPattern)) {
                    continue;
                }
                Collection<String> values = entry.getValue().values();
                output.append(String.format(" %-" + fieldLength + "s |", entry.getKey()));
                if (firstKey.matches(dayPattern)) {
                    values.forEach(data -> output.append(String.format(dayFormat, "", data, "")));
                } else if (firstKey.matches(hourPattern)) {
                    values.forEach(data -> output.append(String.format(" %-" + hourLength + "s |", data)));
                }
                output.append("\n");
                if (elementN != forecast.size()) {
                    output.append(String.format("| %-" + cityLength + "s | %-" + fieldLength + "s---%s |%n", "", "-".repeat(fieldLength), lineDateSeparator));
                    output.append(String.format("| %-" + cityLength + "s |", ""));
                }
            }
            output.append(lineSeparator);
        }
        System.out.println(output);
    }
}
