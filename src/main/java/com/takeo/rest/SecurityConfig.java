package com.takeo.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("devs").password("{noop}devs").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("ns").password("{noop}ns").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("vs").password("{noop}vs").authorities("MANAGER");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		//declares which page (url) have what access type
		
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/wel").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/mgr").hasAuthority("MANAGER")
		.antMatchers("/common").hasAnyAuthority("EMPLOYEE", "MANAGER")
		//Any other URLs which are not configured in above antMatcher
		// Generally declared authenticated in real time 
		.anyRequest().authenticated()
		
		//login form details
		.and()
		.formLogin()
		.defaultSuccessUrl("/wel" , true)
		
		//logout form details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//Exception Details
		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
		
	}
}
