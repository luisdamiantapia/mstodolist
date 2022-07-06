package com.todolist.users.repositories;

import com.todolist.users.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
