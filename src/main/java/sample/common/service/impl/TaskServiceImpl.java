package sample.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import sample.common.dao.entity.Task;
import sample.common.dao.mapper.TaskMapper;
import sample.common.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	private final TaskMapper taskMapper;
	
	public TaskServiceImpl(TaskMapper taskMapper) {
		this.taskMapper = taskMapper ;
	}
	
	@Override
	public void create(Task task) {
		taskMapper.insert(task);
	}
	
	public List<Task> findByUsername(String username){
		return taskMapper.selectByUsername(username);
	}
	
	public Task findById(Long id) {
		return taskMapper.selectById(id);
	}
	
	public void update(Task task) {
		taskMapper.update(task);
	}
	
	public void delete(Long id) {
		taskMapper.deleteById(id);
	}
	
}
