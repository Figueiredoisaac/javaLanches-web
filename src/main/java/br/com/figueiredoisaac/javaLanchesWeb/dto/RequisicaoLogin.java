package br.com.figueiredoisaac.javaLanchesWeb.dto;

import javax.validation.constraints.NotBlank;

import br.com.figueiredoisaac.javaLanchesWeb.model.User;

public class RequisicaoLogin {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public String getEmail() {
		return username;
	}
	public void setEmail(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		return user;
	}
}
