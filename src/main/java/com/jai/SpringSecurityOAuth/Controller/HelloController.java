package com.jai.SpringSecurityOAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String welcome() {
		return "hi jai";
	}
	
}
