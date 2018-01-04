package zhb_springboot.forever.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForeverController {
	
	@RequestMapping("/info")
	public String info(@RequestParam String name){
		return "hi:" + name + ",im from 8762";
	}

}
