package com.example.literalura.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//IMPORTANTE PONER ESTE ARROBA DE ABAJO
@Configuration
//IMPLEMENTAR WebMvcConfigurer
//CorsConfiguration SIRVE PARA PERMITIR QUE UN ORIGEN ESPECIFICO CONSUMA LA API
//EN ESTE CASO ES EL PARAMETRO DE .allowedOrigins() QUE ES "http://127.0.0.1:5501"
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5501")//ESTO ES LA DIRECCION DE LA APLICACION Front-End
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
