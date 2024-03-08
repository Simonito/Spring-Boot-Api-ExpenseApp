package com.shayban.xpenseapi.repository;

import com.shayban.xpenseapi.model.Category;
import org.springframework.data.repository.ListCrudRepository;
import java.util.UUID;

public interface CategoryRepository extends ListCrudRepository<Category, UUID> {
}
