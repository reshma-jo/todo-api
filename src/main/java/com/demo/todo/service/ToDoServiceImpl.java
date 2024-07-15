package com.demo.todo.service;

import com.demo.reportgenerator.model.ToDoData;
import com.demo.reportgenerator.util.ExcelReportGenerator;
import com.demo.todo.exception.ExcelGenerationException;
import com.demo.todo.exception.ItemNotFoundException;
import com.demo.todo.model.ToDo;
import com.demo.todo.repository.ToDoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    ExcelReportGenerator excelReportGenerator;

    @Override
    public ToDo createToDoEntry(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo updateToDoEntry(long id, ToDo toDo) {
        Optional<ToDo> toDoItem = toDoRepository.findById(id);

        if(toDoItem.isPresent()){
            ToDo toDoUpdate = toDoItem.get();
            toDoUpdate.setTitle(toDo.getTitle());
            toDoUpdate.setCompleted(toDo.isCompleted());
            toDoUpdate.setDueDate(toDo.getDueDate());
            toDoRepository.save(toDoUpdate);
            return toDoUpdate;
        } else {
            throw new ItemNotFoundException("To Do item not found!");
        }
    }

    @Override
    public List<ToDo> getAllToDoEntries() {
        return toDoRepository.findAll();
    }

    @Override
    public void deleteToDoEntry(long id) {
        Optional<ToDo> toDoItem = toDoRepository.findById(id);

        if(toDoItem.isPresent()){
            toDoRepository.delete(toDoItem.get());
        } else {
            throw new ItemNotFoundException("To Do item not found!");
        }
    }

    @Override
    public void exportDataToExcel() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ToDoData> excelData = new ArrayList<>();
        List<ToDo> toDoList = toDoRepository.findAll();
        for(ToDo todo : toDoList){
            String json = objectMapper.writeValueAsString(todo);
            ToDoData toDoData = objectMapper.readValue(json, ToDoData.class);
            excelData.add(toDoData);
        }
        try {
            excelReportGenerator.generateToDoExcelReport(excelData, "excel.xlsx");
        } catch (Exception e) {
            throw new ExcelGenerationException("Excel generation failed!");
        }
    }
}
