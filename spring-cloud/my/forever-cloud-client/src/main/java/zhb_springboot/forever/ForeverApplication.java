package zhb_springboot.forever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ForeverApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ForeverApplication.class, args);
	}

}
