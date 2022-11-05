package br.com.figueiredoisaac.javaLanchesWeb.dto;

import javax.validation.constraints.NotBlank;

import br.com.figueiredoisaac.javaLanchesWeb.model.User;

public class RequisicaoCadastrar {
	
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		User user = new User();
		user.setNome(this.nome);
		user.setEmail(this.email);
		user.setPassword(this.password);
		return user;
	}
}
