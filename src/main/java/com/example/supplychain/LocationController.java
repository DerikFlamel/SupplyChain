package com.example.supplychain;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) 
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Location> all() 
    {
        return repository.findAll();
    }

    @PostMapping
    public Location create(@RequestBody Location location)
    {
        return repository.save(location);
    }

    @GetMapping("/{id}")
    public Location getOne(@PathVariable UUID id) 
    {
        return repository.findById(id).orElseThrow();
    }
}
