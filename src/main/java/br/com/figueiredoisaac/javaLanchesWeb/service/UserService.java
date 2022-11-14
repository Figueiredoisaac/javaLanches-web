package br.com.figueiredoisaac.javaLanchesWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.figueiredoisaac.javaLanchesWeb.model.User;
import br.com.figueiredoisaac.javaLanchesWeb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;

	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void salvar(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
	}

	public void atualizar(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
		
	}
	public List<User> visualizar() {
		List<User> users = userRepository.findAll();
		return users;
	}
	public void deletar(String username) {
		userRepository.deleteByUsername(username);
	}
}
