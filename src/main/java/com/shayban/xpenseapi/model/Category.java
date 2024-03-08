package com.shayban.xpenseapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.UUID;

@Table(name = "categories")
public record Category(
        @Id UUID categoryId,
        String name
) {
}
