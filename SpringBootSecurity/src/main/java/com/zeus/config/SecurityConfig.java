package com.zeus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity // 네가 세운 정책 뺏어갈거야.
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 네 기존의 것에 내 정책 세울게
		log.info("SecurityConfig");
		// 1. csrf 토큰 비활성화
		http.csrf().disable();

		// 2. 모든 사이트에 인증이 되면 모두가 인가 된 상태(default) -> 이것을 막는다. -> /board/list 인증 ok,
		// /board/register 인증, 인가(MEMBER)
		http.authorizeRequests().requestMatchers("/board/list").permitAll();
		http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
		http.authorizeRequests().requestMatchers("/notice/list").permitAll();
		http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");
		// 3. id, password 기존 것을 사용하지 않고, 우리가 설계한 아이디와 패스워드, 인가 정책을 세워서 제시하겠다.
		// 4. 아이디나, 패스워드 잘못되었을때 화면에 인증이 안됩니다. 다시 입력하세요. (화면)
//		http.exceptionHandling().accessDeniedPage("/accessError");
		// 5. 로그인 기본 폼을 사용
		http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());
		
		http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

		// 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);

		

		return http.build();
	}

	@Autowired // 셋터주입 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
	}
	
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
	return new CustomAccessDeniedHandler();
	}

	
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
	return new CustomLoginSuccessHandler();
	}

}
