package com.kcb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main")
public class BoardController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String toHome() {
		return "hello~~~!!!...";
	}
	
	@RequestMapping("/jsp1")
	public String jspPage(Model model){
		model.addAttribute("name","hello springBoot1234");
		return "main/index";
	}
	
	@RequestMapping("/jsp2")
	public String jspPage2(Model model){
		model.addAttribute("data","web dependency..");
		return "main/common";
	}

}
