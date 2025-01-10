package com.kh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.domain.Board;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 문자열이든 뭐든 결과값이 무조건 화면으로 가야된다.
public class HomeController {

	@RequestMapping(value = "/memberInsert", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String memberInsert() {
		return "memberInsert";

	}

	@RequestMapping(value = "/ajaxhome6", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String ajaxhome6() {
		return "ajaxhome6";

	}

	@RequestMapping(value = "/registerFileUpForm", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String registerFileUpForm() {
		log.info("registerFileUpForm");
		return "registerFileUpForm";
	}

	@RequestMapping(value = "/registerAjaxFileUpForm", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String registerAjaxFileUpForm() {
		log.info("registerAjaxFileUpForm");
		return "registerAjaxFileUpForm"; // 뷰 파일명
	}

	@RequestMapping(value = "/", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("환영합니다. 클라이언트 지역은 " + locale + "이다.");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home"; // 뷰 파일명
	}
}
