package com.example.task_management_system.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.task_management_system.client.WeatherClient;
import com.example.task_management_system.dto.WeatherResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ThirdPartyApis {
    private final WeatherClient weatherClient;

    public ThirdPartyApis(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("api/weather/{city}")
    public ResponseEntity<WeatherResponse> cityWiseWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherClient.getWeather(city));
    }
    
}
