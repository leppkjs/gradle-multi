package com.kcb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	@RequestMapping("/")
	@ResponseBody
	public String toHome() {
		return "hello~~~!!!...";
	}
	
	@RequestMapping("/jsp")
	public String jspPage(Model model){
		model.addAttribute("name","hello springBoot1234");
		return "index";
	}
	
	@RequestMapping("/jsp2")
	public String jspPage2(Model model){
		model.addAttribute("data","web dependency..");
		return "common";
	}
	
	@RequestMapping("/jsp3")
	public String jspPage3(Model model){
		model.addAttribute("data","web dependency..");
		return "common";
	}

}
