package com.moonlight.spring.test.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping("/test/hellotest")
	public String helloWorld() {
		return "Hello World spring test";
	}
}
