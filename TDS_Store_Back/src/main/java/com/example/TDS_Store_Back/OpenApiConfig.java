package com.example.TDS_Store_Back;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "TDS Store API",
                version = "1.0",
                description = "Documentation de l'API TDS Store",
                contact = @Contact(name = "Ton Nom", email = "ton@email.com"),
                license = @License(name = "Apache 2.0", url = "http://springdoc.org")
        )
)
@Configuration
public class OpenApiConfig {
}
