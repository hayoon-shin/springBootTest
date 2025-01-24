package com.project.controller;

import com.project.service.GeocodingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeocodingController {
    private final GeocodingService geocodingService;

    @Value("${google.maps.api.key}")
    private String apiKey;

    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/geocode")
    public String geocode(@RequestParam("address") String address, Model model) {
        // 주소를 위도/경도로 변환
        double[] latLng = geocodingService.geocode(address, apiKey);

        if (latLng == null) {
            model.addAttribute("error", "Unable to find location for the given address.");
            return "index";
        }

        model.addAttribute("address", address);
        model.addAttribute("lat", latLng[0]);
        model.addAttribute("lng", latLng[1]);
        return "map";
    }
}

