package com.example.supplychain;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController 
{
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) 
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> all() 
    {
        return repository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) 
    {
        return repository.save(product);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable UUID id) 
    {
        return repository.findById(id).orElseThrow();
    }
}
