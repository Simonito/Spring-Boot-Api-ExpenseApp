package com.shayban.xpenseapi.repository;

import com.shayban.xpenseapi.model.User;
import org.springframework.data.repository.ListCrudRepository;
import java.util.UUID;

public interface UserRepository extends ListCrudRepository<User, UUID> {
}
