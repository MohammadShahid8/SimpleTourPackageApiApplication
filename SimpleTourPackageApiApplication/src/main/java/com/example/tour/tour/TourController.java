package com.example.tour.tour;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tour> create(@Valid @RequestBody Tour tour) {
        Tour saved = service.create(tour);
        return ResponseEntity
                .created(URI.create("/api/tours/" + saved.getId()))
                .body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Tour>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
