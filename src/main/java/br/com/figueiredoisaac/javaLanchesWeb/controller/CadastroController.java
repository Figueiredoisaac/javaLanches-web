package br.com.figueiredoisaac.javaLanchesWeb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.figueiredoisaac.javaLanchesWeb.WebSecurityConfig;
import br.com.figueiredoisaac.javaLanchesWeb.dto.RequisicaoCadastrar;
import br.com.figueiredoisaac.javaLanchesWeb.model.Authorities;
import br.com.figueiredoisaac.javaLanchesWeb.model.User;
import br.com.figueiredoisaac.javaLanchesWeb.repository.AuthoritiesRepository;
import br.com.figueiredoisaac.javaLanchesWeb.repository.UserRepository;

@Controller
@RequestMapping("auth")
public class CadastroController {
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("cadastro")
	public String cadastro(RequisicaoCadastrar requisicaoCadastrar) {
		return "auth/cadastro";
	}

	@PostMapping("cadastrar")
	public String cadastroConcluido(@Valid RequisicaoCadastrar requisicaoCadastrar, BindingResult result){
		
		if(result.hasErrors()) {
			return "auth/cadastro";
		}
		
		User user = requisicaoCadastrar.toUser();
		user.setPassword(WebSecurityConfig.getEncoder().encode(user.getPassword()));
		user.setEnabled(true);
		List<User> confirma = userRepository.findByUsername(requisicaoCadastrar.getUsername());
		Authorities auth = new Authorities();
		auth.setUsername(requisicaoCadastrar.getUsername());
		auth.setAuthority("ROLE_USER");

		
		if(confirma.isEmpty()) {
			System.out.println(user.getUsername() + user.getPassword());
			userRepository.save(user);
			authoritiesRepository.save(auth);
			return "index";
		}
		
		return "auth/cadastro";
	}
}
