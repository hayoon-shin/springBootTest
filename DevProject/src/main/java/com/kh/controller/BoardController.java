package com.kh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kh.domain.Board;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 문자열이든 뭐든 결과값이 무조건 화면으로 가야된다. 
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping(value = "/get", params="register")
	public String registerForm() {
		log.info("params 파라미터 GET 방식 등록 폼");
		
		return "board/register";
	}
	@PostMapping(value = "/post", params="register")
	public String register() {
		log.info("params 파라미터 POST 방식 등록 폼");
		
		return "board/list";
	}
	@GetMapping(value = "/get", params="modify")
	public String modifyForm() {
		log.info("params 파라미터 Get 방식 수정 폼");
			
		return "board/modify";
	}
		 
	@PostMapping(value = "/post", params="modify")
	public String modify() {
		log.info("params 파라미터 POST 방식 수정");
					
		return "board/list";
	}	
		
	@GetMapping(value = "/get", params="remove")
	public String removeForm() {
		log.info("params 파라미터 Get 방식 삭제 폼");
					
		return "board/remove";
	}
	@PostMapping(value = "/post", params="remove")
	public String remove() {
		log.info("params 파라미터 POST 방식 삭제");
					
		return "board/list";
	}	
				
	@GetMapping(value = "/get", params="list")
	public String list() {
		log.info("params 파라미터 Get 방식 목록");
					
		return "board/list";
	}
	
	@GetMapping(value= "/get", params="read")
	public String read() {
		log.info("params 파라미터 Get 방식 읽기");
		
		return "board/read";
	}
	
}
