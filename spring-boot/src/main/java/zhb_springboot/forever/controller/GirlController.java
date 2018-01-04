package zhb_springboot.forever.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zhb_springboot.forever.entity.Girl;
import zhb_springboot.forever.properties.GirlProperties;
import zhb_springboot.forever.service.GirlService;
import zhb_springboot.forever.util.ResultUtil;

@RestController
@RequestMapping("/girlController")
public class GirlController {
	
	protected Log log = LogFactory.getLog(GirlController.class);
	
	protected Logger loger = LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlProperties girlProperties;
	
	@Autowired
	private GirlService GirlService;
	
	@PostMapping("/add")
	public Object add(@Valid Girl girl,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			loger.info("girl={}",girl);
			return ResultUtil.error(1, bindingResult.getFieldError().toString());
		}
		return ResultUtil.success(GirlService.save(girl));
	}
	
	@RequestMapping("/insertTwo")
	public void insertTwo(){
	    GirlService.insertTwo();
	}
	
	@RequestMapping("/getGirls")
	public List<Girl> getGirls(){
		log.info(girlProperties.getCupSize() + "  " + girlProperties.getAge());
		return GirlService.getGirls();
	}
	
	@RequestMapping("/getGirlById")
	public Girl getGirlById(){
		return GirlService.getGirlById(11);
	}
	
	@RequestMapping("/getGirlByAge")
	public void getGirlByAge() throws Exception{
		GirlService.getGirlByAge(17);
	}
	
	@RequestMapping("/getCup")
	public String getCup(){
		return "8083";
	}

}
