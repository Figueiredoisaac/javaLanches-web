package br.com.figueiredoisaac.javaLanchesWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping("index")
	public String home() {	
		return "index";
	}
}
