package sample.common.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import sample.common.dao.entity.Login;

@Mapper
public interface LoginMapper {
	Login selectByUsername(@Param("username") String username);

	int insert(@Param("username") String username, @Param("password") String password);
}