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

    @GetMapping("/reverse-geocode")
    public String reverseGeocode(@RequestParam("lat") double lat, 
                                 @RequestParam("lng") double lng, 
                                 Model model) {
        String address = geocodingService.reverseGeocode(lat, lng, apiKey);
        model.addAttribute("address", address);
        model.addAttribute("lat", lat);
        model.addAttribute("lng", lng);
        return "map";
    }
}
