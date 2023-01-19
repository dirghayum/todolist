package com.dmainali.todolist.controller;

import com.dmainali.todolist.model.TodoItem;
import com.dmainali.todolist.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll(){
        return todoRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Optional<TodoItem> getByID(@PathVariable Long id){
        return todoRepo.findById(id);
    }

    @PostMapping
    public TodoItem save (@RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @PutMapping(path = "/{id}")
    public TodoItem update(@RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);
    }


}
