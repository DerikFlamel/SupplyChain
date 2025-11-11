package com.example.supplychain;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movements")
public class MovementController {

    private final MovementRepository repo;

    public MovementController(MovementRepository repo) 
    {
        this.repo = repo;
    }

    // Get all movements
    @GetMapping
    public List<Movement> all() 
    {
        return repo.findAll();
    }

    // Get a single movement by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movement> one(@PathVariable Long id) 
    {
        Optional<Movement> movement = repo.findById(id);
        return movement.map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    // Create a new movement
    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody Movement m) 
    {
        if (m.getTimestamp() == null) 
        {
            m.setTimestamp(OffsetDateTime.now());
        }
        Movement saved = repo.save(m);
        return ResponseEntity
        .created(URI.create("/api/movements/" + saved.getId()))
        .body(saved);
    }

    // Update an existing movement
    @PutMapping("/{id}")
    public ResponseEntity<Movement> update(@PathVariable Long id, @RequestBody Movement updated) 
    {
        return repo.findById(id)
        .map(existing -> 
        {
            existing.setProductName(updated.getProductName());
            existing.setOrigin(updated.getOrigin());
            existing.setDestination(updated.getDestination());
            existing.setQuantity(updated.getQuantity());
            existing.setUnit(updated.getUnit());
            existing.setTimestamp(updated.getTimestamp() != null ? updated.getTimestamp() : OffsetDateTime.now());
            Movement saved = repo.save(existing);
            return ResponseEntity.ok(saved);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    // Delete a movement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) 
    {
        if (repo.existsById(id)) 
        {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
    }
}
