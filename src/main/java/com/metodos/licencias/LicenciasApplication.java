package com.metodos.licencias;

import com.metodos.licencias.view.MenuPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LicenciasApplication {

	public static void main(String[] args) {
                
        //SpringApplication.run(LicenciasApplication.class, args);
        //ConfigurableApplicationContext context = new SpringApplicationBuilder(LicenciasApplication.class).headless(false).run(args);
    	MenuPrincipal menu = new MenuPrincipal();                
	}

}
