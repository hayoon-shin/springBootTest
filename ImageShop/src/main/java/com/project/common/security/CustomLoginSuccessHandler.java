package com.project.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		log.info("onAuthenticationSuccess");
		User customUser = (User) auth.getPrincipal();
		log.info("username = " + customUser.getUsername());
		// 인증 과정에서 발생한 예외 정보를 세션에서 제거
		clearAuthenticationAttribute(request);
		// 사용자가 인증되기 전에 접근을 시도했던 요청을 가져온다
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest != null) {
            // 이전에 요청된 URL로 리디렉션
            String redirectUrl = savedRequest.getRedirectUrl();
            response.sendRedirect(redirectUrl);
        } else {
            // 기본 리디렉션 URL로 이동 (예: 홈 페이지)
            response.sendRedirect(request.getContextPath() + "/home");
        }
	}

	// 인증 과정에서 발생한 예외 정보를 세션에서 제거합니다.
	private void clearAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		// 세션에서 인증 예외 속성을 제거한다.
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
