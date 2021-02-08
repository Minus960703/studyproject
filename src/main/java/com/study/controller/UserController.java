package com.study.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.domain.UserVO;
import com.study.service.UserService;

@Controller
public class UserController {

	@Inject
	UserService service;
	
	@GetMapping("/join")
	public void getjoin() throws Exception{
		
	}
	
	@PostMapping("/join")
	public String postjoin(UserVO vo) throws Exception{
		service.join(vo);
		return "redirect:/";
	}
}
