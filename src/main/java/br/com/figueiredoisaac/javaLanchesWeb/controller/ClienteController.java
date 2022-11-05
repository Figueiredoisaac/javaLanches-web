package br.com.figueiredoisaac.javaLanchesWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@GetMapping("home")
	public String cadastro() {
		return "cliente/home";

	}
}