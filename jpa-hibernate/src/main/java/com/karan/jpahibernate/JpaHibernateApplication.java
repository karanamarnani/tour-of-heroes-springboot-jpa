package com.karan.jpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Configuration
@ComponentScan
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
////				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("HEAD", "GET", "PUT",
////						"POST", "DELETE", "PATCH");
//				registry.addMapping("/**").allowedOrigins("*").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE",
//						"PATCH");
//			}
//		};
//	}

}
