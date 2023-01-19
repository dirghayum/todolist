package com.dmainali.todolist.repository;

import com.dmainali.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoItem,Long> {
}
