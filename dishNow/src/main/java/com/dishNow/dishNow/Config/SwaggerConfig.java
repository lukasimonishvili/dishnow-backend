package com.dishNow.dishNow.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.ParameterIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                    .addParameters("authHeader", new Parameter()
                        .in(ParameterIn.HEADER.toString())
                        .required(false)
                        .name("Authorization")
                        .description("Token de autorización JWT")
                        .example("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
                        .schema(new io.swagger.v3.oas.models.media.StringSchema())
                    ))
                .info(new Info().title("DishNow API").version("1.0"));
    }
}
