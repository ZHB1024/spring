package zhb_springboot.forever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zhb_springboot.forever.feign.FeignCli;
import zhb_springboot.forever.service.ForeverService;

@RestController
public class ForeverController {
	
	@Autowired
	ForeverService foreverService;
	
	@Autowired
	FeignCli feignCli;
	
	@RequestMapping("/ribbonTemp")
	public String ribbonTemp(@RequestParam String name){
		return foreverService.info(name);
	}
	
	
	@RequestMapping("/feign")
	public String feign(@RequestParam String name){
		return feignCli.sayHiFromClient(name);
	}
	
}
