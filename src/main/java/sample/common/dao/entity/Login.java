package sample.common.dao.entity;

import java.time.LocalDateTime;

public class Login {
	private Long id;
	private String username;
	private String password;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public long getId() { return id;}
	public void setId(Long id) { this.id = id;}

	public String getUsername() {return username;}
	public void setUsername(String username) { this.username = username;}
	
	public String getPassword() {return password;}
	public void getPassword(String password) { this.password = password;}
	
	public LocalDateTime getCreated_at() {return created_at;}
	public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at;}
	
	public LocalDateTime getUpdated_at() {return updated_at;}
	public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at;}
}
