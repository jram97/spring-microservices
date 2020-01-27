package sv.com.stjacks.sjpos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SjposEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjposEurekaServerApplication.class, args);
	}

}
