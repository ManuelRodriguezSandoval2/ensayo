package cl.inacap.microservicioexistencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicioExistenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioExistenciasApplication.class, args);
	}

}
