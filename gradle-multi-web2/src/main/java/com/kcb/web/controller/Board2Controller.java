package com.kcb.web.controller;

import java.security.PrivateKey;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kcb.utility.RSAUtil;
import com.kcb.utility.vo.RSA;

@Controller
@RequestMapping("main")
public class Board2Controller {
	
	@Autowired
	private RSAUtil rsaUtil;
	
	@RequestMapping("/hello2")
	@ResponseBody
	public String toHome() {
		return "hello~~~!!!...";
	}
	
	
	@RequestMapping("/jsp3")
	public String jspPage3(Model model){
		model.addAttribute("data","web dependency..");
		return "main/common2";
	}
	
	// 로그인 페이지 진입
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model) {
	    // RSA 키 생성
	    PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
	    if (key != null) { // 기존 key 파기
	        session.removeAttribute("RSAprivateKey");
	    }
	    RSA rsa = rsaUtil.createRSA();
	    model.addAttribute("modulus", rsa.getModulus());
	    model.addAttribute("exponent", rsa.getExponent());
	    session.setAttribute("RSAprivateKey", rsa.getPrivateKey());
	    return "main/login";
	}
	
	// 로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session, RedirectAttributes ra) {
	    // 개인키 취득
	    PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
	    if (key == null) {
	        ra.addFlashAttribute("resultMsg", "비정상 적인 접근 입니다.");
	        return "redirect:/main/login";
	    }
	 
	    // session에 저장된 개인키 초기화
	    session.removeAttribute("RSAprivateKey");
	 
	    // 아이디/비밀번호 복호화
	    try {
	        String email = rsaUtil.getDecryptText(key, user.getEmail());
	        String password = rsaUtil.getDecryptText(key, user.getPassword());
	 
	        // 복호화된 평문을 재설정
	        user.setEmail(email);
	        user.setPassword(password);
	    } catch (Exception e) {
	        ra.addFlashAttribute("resultMsg", "비정상 적인 접근 입니다.");
	        return "redirect:/main/login";
	    }
	 
	    // 로그인 로직 실행
	    // userService.login(user);
	    
	    return "redirect:/main/jsp3";
	}

}
