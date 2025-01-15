package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.domain.Board;
import com.zeus.domain.Member;
import com.zeus.service.BoardService;
import com.zeus.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
@MapperScan(basePackages = "com.zeus.mapper")
public class MemberController {
	// 서비스를 이용해서 접근
	@Autowired
	private MemberService service;
	
	@GetMapping("/search")
	public String search(@RequestParam(value = "userName", required = false) String userName, Model model) throws Exception {
	    List<Member> members = service.search(userName); // 검색 결과 가져오기
	    model.addAttribute("members", members); // 검색 결과를 모델에 추가
	    model.addAttribute("member", new Member()); // 검색 폼에 필요한 객체 추가
	    return "user/list"; // JSP 파일 이름
	}


	
	//사용자입력 폼요청 (/WEB-INF/views/user/register.jsp)
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Member member, Model model) throws Exception {
		log.info("UserRegisterForm");
	}
	
	//사용자 입력내용 디비저장하고 성공이 되면 (/WEB-INF.views/user/success.jsp/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) throws Exception {
		service.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "user/success";
	}

	//사용자 정보리스트 요청 (/WEB-INF/views/user/list.jsp)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
		Member member = new Member();
        model.addAttribute("member", member);
	}
	
	//사용자 정보 상세내용 요청 (/WEB-INF/views/user/read.jsp)
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int userNo, Model model) throws Exception {
		model.addAttribute(service.read(userNo));
	}
	
	//사용자 삭제 요청 (/WEB-INF/views/user/success.jsp)
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int userNo, Model model) throws Exception {
		service.remove(userNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "user/success";
	}

	//사용자 수정폼 요청 (/WEB-INF/views/user/modify.jsp)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int userNo, Model model) throws Exception {
		model.addAttribute(service.read(userNo));
	}

	//사용자 수정내용 디비에 저장 요청 (/WEB-INF/views/user/success.jsp)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Member member, Model model) throws Exception {
		service.modify(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "user/success";
	}
}
