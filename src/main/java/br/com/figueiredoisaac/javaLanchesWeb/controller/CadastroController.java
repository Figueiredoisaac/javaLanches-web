package br.com.figueiredoisaac.javaLanchesWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.figueiredoisaac.javaLanchesWeb.dto.RequisicaoCadastrar;
import br.com.figueiredoisaac.javaLanchesWeb.model.User;
import br.com.figueiredoisaac.javaLanchesWeb.service.UserService;

@Controller
@RequestMapping("auth")
public class CadastroController {

	@Autowired
	private UserService userService;

	@GetMapping("cadastro")
	public String cadastro() {
		return "auth/cadastro";
	}

	@PostMapping("cadastrar")
	public String cadastroConcluido(RequisicaoCadastrar requisicaoCadastrar, Model model) {
		
		User user = requisicaoCadastrar.toUser();
		System.out.println(user.getNome() + user.getEmail() + user.getPassword());
		userService.salvar(user);
		
		return "auth/cadastro";
	}
}
