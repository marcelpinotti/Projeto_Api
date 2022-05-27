package com.gft.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement; 
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	  public OpenAPI projetoAPI() {
	      return new OpenAPI()
	              .info(new Info().title("API Starters")
	              .description("Consulta e Cadastro de Starters")
	              .version("v1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .addSecurityItem(new SecurityRequirement().addList("swagger_JWT"))
	              .components(
	            		  new Components()
	            		  .addSecuritySchemes("swagger_JWT",
	            				  new SecurityScheme()
	            				  .name("swagger_JWT")
	            				  .type(SecurityScheme.Type.HTTP)
	            				  .scheme("bearer")
	            				  .bearerFormat("JWT")
	            				  )
	            		  );
	}
}