package br.com.figueiredoisaac.javaLanchesWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.figueiredoisaac.javaLanchesWeb.dto.RequisicaoLogin;
import br.com.figueiredoisaac.javaLanchesWeb.model.User;
import br.com.figueiredoisaac.javaLanchesWeb.service.UserService;

@Controller
@RequestMapping("auth")
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String login() {
		return "auth/login";
	}

	@PostMapping("autenticado")
	public String autenticando(RequisicaoLogin requisicaoLogin, Model model) {

		User user = requisicaoLogin.toUser();
		System.out.println(user.getNome() + " - " +user.getPassword());
		List<User> temp = userService.visualizar();
		for (User u : temp) {
			if (user.getNome().contentEquals( u.getNome()) && user.getPassword().contentEquals(u.getPassword())) {
				System.out.println(u.getNome() +" - "+ user.getNome());
				return "cliente/home";
			}	
		}
		System.out.println("autenticação falhou");
		return "auth/login";
	}
}
