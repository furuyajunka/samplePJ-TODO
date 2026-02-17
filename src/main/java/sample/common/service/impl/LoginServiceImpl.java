package sample.common.service.impl;

import org.springframework.stereotype.Service;

import sample.common.dao.entity.Login;
import sample.common.dao.mapper.LoginMapper;
import sample.common.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private final LoginMapper loginMapper;
	
	public LoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	@Override
	public boolean authenticate(String username,String password) {
		Login login = loginMapper.selectByUsername(username);
		if(login == null)return false;
		
		return password != null && password.equals(login.getPassword());
	}
	
	public boolean register(String username, String password) {
		Login existing = loginMapper.selectByUsername(username);
		if(existing != null) {
			return false;
		}
		loginMapper.insert(username,password);
		return true;
	}
}