package com.nikhilsable.weatherservice.controller;

import com.nikhilsable.weatherservice.entity.Weather;
import com.nikhilsable.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Get weather by city
    @GetMapping
    public String getWeather(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }

    // Save weather
    @PostMapping
    public Weather addWeather(@RequestBody Weather weather) {
        return weatherService.saveWeather(weather);
    }

    // Get all weather records
    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherService.getAllWeather();
    }
    @GetMapping("/health")
    public String getHealth(){
        return "healthy";
    }
}