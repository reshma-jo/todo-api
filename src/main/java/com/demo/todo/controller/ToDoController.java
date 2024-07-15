package com.demo.todo.controller;

import com.demo.todo.model.ToDo;
import com.demo.todo.service.ToDoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDoEntries();
    }

    @PostMapping("/")
    public ToDo addTodo(@RequestBody ToDo todo) {
        return toDoService.createToDoEntry(todo);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable long id, @RequestBody ToDo todo){
        return toDoService.updateToDoEntry(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        toDoService.deleteToDoEntry(id);
    }

    @GetMapping("/export")
    public void exportToExcel() throws JsonProcessingException {
       toDoService.exportDataToExcel();
    }
}
