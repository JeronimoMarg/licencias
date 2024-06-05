package com.metodos.licencias;

import com.metodos.licencias.controller.TitularesController;
import com.metodos.licencias.view.MenuPrincipal;
import com.metodos.licencias.view.Titulares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.metodos.licencias")
@EntityScan(basePackages = "com.metodos.licencias.logic")
@EnableJpaRepositories(basePackages = "com.metodos.licencias.repository")
public class LicenciasApplication {

	public static void main(String[] args) {
                
        //SpringApplication.run(LicenciasApplication.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(LicenciasApplication.class).headless(false).run(args);
        MenuPrincipal menu = context.getBean(MenuPrincipal.class);
        //menu.setVisible(true);
        
	}

}
