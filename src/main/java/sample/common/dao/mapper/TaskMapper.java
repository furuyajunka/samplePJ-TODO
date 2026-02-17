package sample.common.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.common.dao.entity.Task;

@Mapper
public interface TaskMapper {
    List<Task> selectByUsername(@org.apache.ibatis.annotations.Param("username") String username);
    int insert(Task task);
    
    Task selectById(Long id);
    int update(Task task);
    
    int deleteById(Long id);
}