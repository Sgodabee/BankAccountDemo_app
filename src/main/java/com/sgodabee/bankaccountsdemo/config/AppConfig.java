package com.sgodabee.bankaccountsdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.sgodabee.bankaccountdemo_v1"})

public class AppConfig extends WebMvcConfigurationSupport{


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("assets/css/**","assets/fonts/**","assets/images/**","assets/js/**","assets/placeholder/**")
                .addResourceLocations("classpath:/static/assets/css/","classpath:/static/assets/fonts/","classpath:/static/assets/js/","classpath:/static/assets/images/","classpath:/static/assets/placeholder/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver()
    {

        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);


        return jspViewResolver;
    }


}
