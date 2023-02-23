package com.gateways.renato.springbootjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

}
