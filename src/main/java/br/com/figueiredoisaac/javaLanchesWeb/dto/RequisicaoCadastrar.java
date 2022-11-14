package br.com.figueiredoisaac.javaLanchesWeb.dto;

import javax.validation.constraints.NotBlank;

import br.com.figueiredoisaac.javaLanchesWeb.model.User;

public class RequisicaoCadastrar {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
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
