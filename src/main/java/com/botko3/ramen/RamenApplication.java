package com.botko3.ramen;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ramen API",version="1.0.0",description = "Ramen shop info",contact = @Contact(name = "Afra Chan",email = "afraslchan@gmail.com")))
public class RamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamenApplication.class, args);
	}

}
