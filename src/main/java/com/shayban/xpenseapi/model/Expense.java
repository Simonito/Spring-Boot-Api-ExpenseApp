package com.shayban.xpenseapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "expenses")
public record Expense(
    @Id UUID expenseId,
    UUID userId,
    UUID categoryId,
    Double amount,
    LocalDateTime paidAt,
    LocalDateTime createdAt
) {
}
