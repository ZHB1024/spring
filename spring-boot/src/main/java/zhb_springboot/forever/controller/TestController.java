package zhb_springboot.forever.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import zhb_springboot.forever.entity.Girl;
import zhb_springboot.forever.service.GirlService;

@Controller
@RequestMapping("/testController")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private GirlService GirlService;
	
	@RequestMapping("/toThemeleaf")
	public String toThemeleaf(HttpServletRequest requst,HttpServletResponse response,ModelMap modelMap){
		modelMap.addAttribute("name", "张三");
		return "test/helloHtml";
	}
	
	@RequestMapping("/getGirls")
	public String getGirls(HttpServletRequest requst,HttpServletResponse response,ModelMap modelMap){
		List<Girl> girls = GirlService.getGirls();
		modelMap.addAttribute("girls", girls);
		return "girl/index";
	}
	
	@RequestMapping("/download")
    public void download(HttpServletRequest request,HttpServletResponse response,String id){
		logger.info(id);
        Resource resource = new ClassPathResource("static/images/解锁申请表.jpg");
        response.setContentType("image/jpeg");
        FileInputStream fis = null;
        //InputStream fis = null;
        ServletOutputStream sos = null;
        try {
            fis = new FileInputStream(resource.getFile());
            //fis = resource.getInputStream();
            sos = response.getOutputStream();
            int lenght;
            byte[] buf = new byte[1024];
            while((lenght = fis.read(buf, 0, 1024)) != -1){
                sos.write(buf,0,lenght);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != sos) {
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	

}
