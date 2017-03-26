package pl.hawk.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/contacts").setViewName("contacts");
        registry.addViewController("/").setViewName("contacts");
        registry.addViewController("/hello").setViewName("contacts");
        registry.addViewController("/login").setViewName("login");
    }

}
