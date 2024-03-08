package com.shayban.xpenseapi.controller;

import com.shayban.xpenseapi.model.Expense;
import com.shayban.xpenseapi.repository.ExpenseRepository;
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
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseRepository repo;

    public ExpenseController(ExpenseRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Expense> getAll() {
        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public Expense getAll(@PathVariable("id") UUID id) {
        return this.repo
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "expense not found"));
    }

    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        // TODO: add verification and exception handling
        return repo.save(expense);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable UUID id, @RequestBody Expense expense) {
        repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "expense not found"));
        return repo.save(expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        final Expense toDel = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "expense not found"));
        repo.delete(toDel);
    }
}
