package com.github.smalnote.genesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/")
	public String index() {
		return "/index.html";
	}
	
}