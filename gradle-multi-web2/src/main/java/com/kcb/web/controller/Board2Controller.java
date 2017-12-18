package com.kcb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Board2Controller {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String toHome() {
		return "hello~~~!!!...";
	}
	
	
	@RequestMapping("/jsp3")
	public String jspPage3(Model model){
		model.addAttribute("data","web dependency..");
		return "common2";
	}

}
