package sample.common.service;

import java.util.List;

import sample.common.dao.entity.Task;

public interface TaskService {
	List<Task> findByUsername(String username, int page, int size);

	void create(Task task);

	int countByUsername(String username);

	Task findById(Long id);

	void update(Task task);

	void delete(Long id);
}
