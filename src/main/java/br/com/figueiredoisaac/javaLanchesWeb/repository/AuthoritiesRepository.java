package br.com.figueiredoisaac.javaLanchesWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.figueiredoisaac.javaLanchesWeb.model.Authorities;


@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}
