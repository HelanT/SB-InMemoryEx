package com.takeo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/home")
	public String getHomePage()
	{
		return "homePage";
	}
	
	@GetMapping("/wel")
	public String getWelcomePage()
	{
		return "welcomePage";
	}
	
	@GetMapping("/admin")
	public String getAdminPage()
	{
		return "adminPage";
	}
	
	@GetMapping("/emp")
	public String getEmpPage()
	{
		return "empPage";
	}
	
	@GetMapping("/common")
	public String getCommonPage()
	{
		return "commonPage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDeniedPage()
	{
		return "accessDeniedPage";
	}

}
