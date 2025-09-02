package developmentaid.controller;

import developmentaid.service.ForecastService;
import developmentaid.view.ForecastView;

import java.time.LocalDate;
import java.util.*;

public class ForecastController {
    private final ForecastView view;
    private final ForecastService service;

    public ForecastController() {
        view = new ForecastView();
        service = new ForecastService();
    }

    public void getForecastByCitiesAndDate(List<String> queries, LocalDate date) {
        List<LinkedHashMap<String, LinkedHashMap<String, String>>> forecastsResults = new ArrayList<>();
        for (String query : queries ) {
            Optional<LinkedHashMap<String, LinkedHashMap<String, String>>> forecast = Optional.ofNullable(service.getForecastByQueryAndDate(query, date));
            forecast.ifPresent(forecastsResults::add);
        }
        view.generateTableByLocationFieldsDates(forecastsResults);
    }
}
