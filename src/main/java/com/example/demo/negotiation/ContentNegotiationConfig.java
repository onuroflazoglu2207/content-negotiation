package com.example.demo.negotiation;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc
public class ContentNegotiationConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).favorParameter(true).
                parameterName("mediaType").ignoreAcceptHeader(true).useJaf(false).
                //  defaultContentType(MediaType.ALL).
                //  defaultContentType( MediaType.TEXT_HTML).
                //  defaultContentType( MediaType.APPLICATION_PDF).
                //  defaultContentType( MediaType.IMAGE_PNG).
                defaultContentType(MediaType.APPLICATION_JSON/*response type*/, MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML);
    }
}