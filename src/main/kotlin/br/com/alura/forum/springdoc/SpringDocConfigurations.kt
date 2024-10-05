package br.com.alura.forum.springdoc

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringDocConfigurations {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title(" Kotlin API + H2 + Spring Cache")
                    .version("v1")
                    .description("[GitHub](https://github.com/hada97/kotlin-api)\n\n")
            )
    }
}