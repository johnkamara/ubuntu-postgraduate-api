package com.preving.intranet.restfulapi.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by javier-montesinos on 27/03/17.
 */
@Configuration
@EnableWebMvc
public class WebConfigApplication extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // necesario para aceptar CORS OPTIONS
        registry.addMapping("/**").allowedMethods("*");
    }
}
