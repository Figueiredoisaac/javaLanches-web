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
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String login() {
		return "login";
	}

}
