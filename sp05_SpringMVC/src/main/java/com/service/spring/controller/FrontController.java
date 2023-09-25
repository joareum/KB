package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FrontController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값 받아서
		 * 2. vo생성
		 * 3. DAO리턴 받고..비즈니스 로직 호출
		 * 4. 반환값 바인딩
		 * 5. 페이지 이동(네비게이션)
		 * 
		 * 1~4번까지를 했다치고 5번만 해볼게요
		 * String--->ModelAndVIew 객체 생성해서 리턴
		 */
		return new ModelAndView("result", "message", "Hello First Spring MVC Framework"); 
		
		/* 1. request 바인딩 (message = Hello First Spring ~)
		 * 2. result.jsp 페이지로 forwarding 된다.
		 * 결과페이지가 저장되는 물리적 위치는 알 수 없음. / 결과페이지의 확장자도 알 수 없음.  */
	}

}
