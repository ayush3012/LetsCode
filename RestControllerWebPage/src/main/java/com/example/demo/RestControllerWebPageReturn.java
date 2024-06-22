package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController//:-this will return index string but controller looks for jsp page
public class RestControllerWebPageReturn {

	@GetMapping("/GetPage")
	public String getPage()
	{
		return "index";
		//index.jsp is in src/main/view/
		/*add these lines in application.properties
		//spring.mvc.view.prefix=/view/
		//spring.mvc.view.suffix=.jsp
		  */
		//add jasper dependency so that server translate jsp to servlet
	}
}
