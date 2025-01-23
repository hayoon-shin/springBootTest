package com.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.DTO.GeocodingResponse;

@Service
public class GeocodingService {
    private static final String API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public String reverseGeocode(double lat, double lng, String apiKey) {
        String url = String.format("%s?latlng=%f,%f&key=%s", API_URL, lat, lng, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        try {
            GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);

            if (response != null && "OK".equals(response.getStatus())) {
                return response.getResults().get(0).getFormattedAddress();
            } else {
                return "No results found or API error.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while calling the API.";
        }
    }
}
