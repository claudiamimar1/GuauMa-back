package com.uniquindio.guauma.interfaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.uniquindio.guauma"})
@EnableJpaRepositories(basePackages = {"com.uniquindio.guauma.infraestructura.persistencia"})
@EntityScan("com.uniquindio.guauma.dominio.modelo")
public class GuaumaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuaumaApplication.class, args);
	}

}
