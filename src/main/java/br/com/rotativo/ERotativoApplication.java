package br.com.rotativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Sistema Para Estacionamento Rotativo.",
			version = "1.0",
			description = "Documentando uma api para um sistema de estacionamento rotativo.",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class ERotativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERotativoApplication.class, args);
	}

}
