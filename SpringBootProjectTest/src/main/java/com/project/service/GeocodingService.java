package com.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.DTO.GeocodingResponse;

@Service
public class GeocodingService {
    private static final String API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public double[] geocode(String address, String apiKey) {
        String url = String.format("%s?address=%s&key=%s", API_URL, address.replace(" ", "+"), apiKey);

        RestTemplate restTemplate = new RestTemplate();
        try {
            GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);

            if (response != null && "OK".equals(response.getStatus())) {
                // 첫 번째 결과에서 위도/경도 추출
                double lat = response.getResults().get(0).getGeometry().getLocation().getLat();
                double lng = response.getResults().get(0).getGeometry().getLocation().getLng();
                return new double[]{lat, lng};
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

