package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {
	@RequestMapping("/hello")
	public String doHello(Model model) {
		model.addAttribute("data","Hello SpringBOot Start~!");
		return "result";
	}
}
