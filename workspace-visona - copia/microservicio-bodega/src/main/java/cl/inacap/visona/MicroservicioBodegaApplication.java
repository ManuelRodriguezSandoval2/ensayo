package cl.inacap.visona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MicroservicioBodegaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioBodegaApplication.class, args);
	}

}