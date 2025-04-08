package org.example.learnpostgresql.controller;

import lombok.RequiredArgsConstructor;
import org.example.learnpostgresql.entity.Location;
import org.example.learnpostgresql.repository.LocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class testController {

    private final LocationRepository locationRepository;

    @GetMapping("/nearby")
    public List<Location> findNearby(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "1000") double radius) {
        System.out.println("TEST");
        return locationRepository.findNearby(lng, lat, radius);
    }
}
