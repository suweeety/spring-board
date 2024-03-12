package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CommonController { //권한없는 사용자에게 예외처리용 페이지 전달
	
	@GetMapping("/accessError") //시큐리티에서 보낸 에러화면 처리하는 분기점
	public void accessDenied(Authentication auth, Model model) {
		// import org.springframework.security.core.Authentication;
		log.info("accessDenied 메서드 호출......." + auth);
		model.addAttribute("msg", "access denied (권한이 없는 사용자입니다.)");
	}
	
	@GetMapping("/customLogin") //http://localhost/customLogin (내가 만든 로그인 폼)
	public void loginInput(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) { //error 객체가 넘어올때
			model.addAttribute("error", "로그인 에러입니다. 계정을 확인하세요.");
		}
		if(logout != null) { //logout 객체가 넘어올때
			model.addAttribute("logout", "로그아웃 실행");
		}
	}
	
}
