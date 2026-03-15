package com.example.task_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    private String name;
    private Main main;
    private List<Weather> weather;

    @Getter
    @Setter
    public static class Main {
        private double temp;
        private double temp_min;
        private double temp_max;
        private double pressure;
        private double humidity;
    }

    @Getter
    @Setter
    public static class Weather {
        private String description;
    }
}