package com.example.weather.model;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {
    private String resolvedAddress;
    private String description;
    private List<Day> days;

    @Data
    public static class Day {
        private String datetime;
        private double temp;
        private String conditions;
    }
}
