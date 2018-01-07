package com.kcb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kcb.web.service.CityService;

@Controller
@RequestMapping("main")
public class Board2Controller {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping("/hello2")
	@ResponseBody
	public String toHome() {
		return "hello~~~!!!... : " + cityService.getCityName(1);
	}
	
	
	@RequestMapping("/jsp3")
	public String jspPage3(Model model){
		model.addAttribute("data","web dependency..");
		return "main/common2";
	}

}
