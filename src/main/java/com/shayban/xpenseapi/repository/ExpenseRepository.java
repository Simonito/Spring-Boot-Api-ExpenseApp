package com.shayban.xpenseapi.repository;

import com.shayban.xpenseapi.model.Expense;
import org.springframework.data.repository.ListCrudRepository;
import java.util.UUID;

public interface ExpenseRepository extends ListCrudRepository<Expense, UUID> {
}
