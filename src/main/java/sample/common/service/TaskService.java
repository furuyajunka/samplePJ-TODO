package sample.common.service;

import java.util.List;

import sample.common.dao.entity.Task;

public interface TaskService {
    List<Task> findByUsername(String username);
    void create(Task task);
    
    Task findById(Long id);
    void update(Task task);
    
    void delete(Long id);
}
