package com.nikhilsable.weatherservice.service;

import com.nikhilsable.weatherservice.entity.Weather;
import com.nikhilsable.weatherservice.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String getWeatherByCity(String city) {
        return weatherRepository.findByCity(city)
                .map(Weather::getForecast)
                .orElse("Weather data not available");
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }
}