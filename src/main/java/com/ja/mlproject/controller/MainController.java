package com.ja.mlproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "mainPage";
	}
}
