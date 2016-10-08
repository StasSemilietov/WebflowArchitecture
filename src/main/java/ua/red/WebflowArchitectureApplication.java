package ua.red;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/**
 * spring-config.xml contains only ServletContextAttributeExporter for EntityFacade bean for flows
 */
@ImportResource("classpath:spring/spring-config.xml")

public class WebflowArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebflowArchitectureApplication.class, args);
	}
}
