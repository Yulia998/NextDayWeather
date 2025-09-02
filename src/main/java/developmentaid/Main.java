package developmentaid;

import developmentaid.controller.ForecastController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(Arrays.asList("Chisinau", "Madrid", "Kyiv", "Amsterdam"));
        ForecastController controller = new ForecastController();
        controller.getForecastByCitiesAndDate(cities, LocalDate.now().plusDays(1));
    }
}