package com.example.task_management_system.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.task_management_system.dto.WeatherResponse;

@Service
public class WeatherClient {
    private final RestTemplate restTemplate;
    private final String API_KEY;
    private final Logger logger;

    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        logger = LoggerFactory.getLogger(WeatherClient.class);
        API_KEY = System.getenv("OPEN_WEATHER_API_KEY");
    }

    public WeatherResponse getWeather(String city) {

        WeatherResponse weatherResponse;
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid=" + API_KEY
                + "&units=metric";
        try {
            weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
        }
        catch(Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }

        return weatherResponse;
    }
}
