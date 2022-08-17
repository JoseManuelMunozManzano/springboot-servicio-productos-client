package com.jmunoz.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Con solo informar la dependencia en el pom (eureka-client) de forma automática se configura como cliente.
// Pero igualmente es buena práctica (no obligatorio) indicarlo con una anotación en la clase principal.
// Se indica de forma explícita con la anotación @EnableEurekaClient
@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioProductosApplication.class, args);
	}

}
