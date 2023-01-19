package com.moonlight.spring.test.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {
	
	@GetMapping("/test01")
	public String test01() {
		return "jstl/test01";
	}
	
	@GetMapping("/test02")
	public String test02() {
		return "jstl/test02";
	}
}
