package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean 
	CommandLineRunner datos(UsuarioRepository repo){
		return args -> repo.save(new Usuario("ana","Patitas2026","Ana"));
	}
}
