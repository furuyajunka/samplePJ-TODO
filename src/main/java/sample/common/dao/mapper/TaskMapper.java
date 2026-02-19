package sample.common.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import sample.common.dao.entity.Task;

@Mapper
public interface TaskMapper {
	List<Task> selectByUsername(@Param("username") String username,
			@Param("limit") int limit,
			@Param("offset") int offset);

	int insert(Task task);

	int countByUsername(@Param("username") String username);

	Task selectById(Long id);

	int update(Task task);

	int deleteById(Long id);
}