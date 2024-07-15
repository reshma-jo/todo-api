package com.demo.todo.service;

import com.demo.todo.model.ToDo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ToDoService {
    ToDo createToDoEntry(ToDo toDo);
    ToDo updateToDoEntry(long id, ToDo toDo);
    List<ToDo> getAllToDoEntries();
    void deleteToDoEntry(long id);
    void exportDataToExcel() throws JsonProcessingException;
}
