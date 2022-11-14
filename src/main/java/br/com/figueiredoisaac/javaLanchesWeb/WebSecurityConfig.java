package br.com.figueiredoisaac.javaLanchesWeb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.figueiredoisaac.javaLanchesWeb.controller.CadastroController;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/auth/**", "/index", "/css/**", "/js/**", "/img/**").permitAll()
		.anyRequest().authenticated().and()
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/cliente/home", true)
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/index"))
				.csrf().disable();;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
	}

}