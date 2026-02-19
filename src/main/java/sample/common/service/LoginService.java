package sample.common.service;

public interface LoginService {
	boolean authenticate(String username, String password);

	boolean register(String username, String password);
}
