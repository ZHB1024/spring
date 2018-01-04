package zhb_springboot.forever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ForeverApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ForeverApplication.class, args);
	}

}
