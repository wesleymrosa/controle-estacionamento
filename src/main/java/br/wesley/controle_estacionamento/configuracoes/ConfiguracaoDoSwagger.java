package br.wesley.controle_estacionamento.configuracoes;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfiguracaoDoSwagger {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Controle de Estacionamento API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de vagas de estacionamento. Permite cadastro, listagem, busca, atualização e exclusão de vagas.")
                        .contact(new Contact()
                                .name("Wesley Martins Rosa")
                                .email("wesleymrosa@gmail.com")
                                .url("https://www.linkedin.com/in/wesley-martins-rosa-5118aa15a"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}

