package cl.inacap.microservicio.ingreso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicioIngresoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioIngresoApplication.class, args);
	}

}
