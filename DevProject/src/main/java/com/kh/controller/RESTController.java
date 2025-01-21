package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // @Condroller ResponseBody
public class RESTController {
	@GetMapping("/blog")
	public String httpGet() {
		User user = User.builder().id(1).userName("zeus").password("123456").email("ssh3324@gmail.com").build();
		return "get 요청처리";
	}

	
	@PostMapping("/blog")
	//@ResponesBody => 자바객체를 json방식으로 바꿔서 브라우저에게 보낸다.
	//@RequestBody => 브라우저가 json => 자바객체로 바꾸겠다.
	
	public List<User> httpPost(@RequestBody User user) {
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user);
		
	return list;
	}
	@PutMapping("/blog")
	public String httpPut(@RequestBody User user) {
	return "PUT 요청처리"+user.toString();
	}
	@DeleteMapping("/blog")
	public String httpDelete(@RequestParam int id) {
	return "DELETE 요청처리"+id;
	}


}
