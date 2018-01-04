package zhb_springboot.forever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ForeverService {
	
	@Autowired
    RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "error")
    public String info(String name) {
        return restTemplate.getForObject("http://service-hi/info?name="+name,String.class);
    }
	
	public String error(String name){
		return "hi," + name + ",sorry error";
	}


}
