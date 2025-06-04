package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Cacheable(value = "weather", key = "#location")
    public WeatherResponse getWeather(String location) {
        String url = baseUrl + location + "?key=" + apiKey;
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
