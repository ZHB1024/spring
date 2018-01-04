package zhb_springboot.forever.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi")
public interface FeignCli {
	
	@RequestMapping(value = "/info")
    String sayHiFromClient(@RequestParam(value = "name") String name);

}
