package com.nikhilsable.weatherservice.service;

import com.nikhilsable.weatherservice.entity.Weather;
import com.nikhilsable.weatherservice.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String getWeatherByCity(String city) {

        System.out.println("Fetching data from DB: " + city);

        Optional<Weather> weather = weatherRepository.findByCity(city);

        return weather
                .map(Weather::getForecast)
                .orElse("Weather data not available");
    }
}