package com.shayban.xpenseapi.controller;

import com.shayban.xpenseapi.model.Category;
import com.shayban.xpenseapi.model.Expense;
import com.shayban.xpenseapi.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Category> findAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Category getAll(@PathVariable("id") UUID id) {
        return this.repo
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
    }


    @PostMapping
    public Category add(@RequestBody Category category) {
        // TODO: add verification and exception handling
        return repo.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable UUID id, @RequestBody Category category) {
        repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
        return repo.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        final Category toDel = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
        repo.delete(toDel);
    }
}
