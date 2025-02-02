package com.example.proyectohoteles.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("HotelesAPI")
                        .description("API para gestión de hoteles")
                        .contact(new Contact()
                                .name("Diego")
                                .email("diego@diego.com")
                                .url("https://diego.com"))
                        .version("1.0"));
    }

    //http://localhost:9999/swagger-ui.html
    //http://localhost:9999/v3/api-docs.yaml
    //http://localhost:9999/v3/api-docs
}