package com.zeus.common.Interceptor;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private static final String USER_INFO = "userInfo";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle");
		String requestURL = request.getRequestURI();
		log.info("requestURL : " + requestURL);
		HandlerMethod handlemethod = (HandlerMethod) handler;
		Method methodObj = handlemethod.getMethod();
		log.info("Bean: " + handlemethod.getBean());
		log.info("Method: " + methodObj);
		HttpSession session = request.getSession();
		if (session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
		String requestURL = request.getRequestURI();
		log.info("postHandle requestURL : " + requestURL);
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		log.info("postHandle Bean: " + method.getBean());
		log.info("postHandle Method: " + methodObj);
				
		HttpSession session = request.getSession();
		
		//모델에 "user" member등록 컨트롤러. login()함수에 실행 model.addAttribute("user", member);
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("user");
		if (member != null) {
			log.info("postHandle member != null");
			session.setAttribute(USER_INFO, member);
			response.sendRedirect("/");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
		String requestURL = request.getRequestURI();
		log.info("afterCompletion requestURL : " + requestURL);
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		log.info("afterCompletion Bean: " + method.getBean());
		log.info("afterCompletion Method: " + methodObj);
	}
}
