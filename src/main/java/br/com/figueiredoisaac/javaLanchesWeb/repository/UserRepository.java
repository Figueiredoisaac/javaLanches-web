package br.com.figueiredoisaac.javaLanchesWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.figueiredoisaac.javaLanchesWeb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	void deleteByUsername(String username);

	List<User> findByUsername(String username);

}
