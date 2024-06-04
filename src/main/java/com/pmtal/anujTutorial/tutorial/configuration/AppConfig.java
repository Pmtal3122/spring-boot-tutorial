package com.pmtal.anujTutorial.tutorial.configuration;

import com.pmtal.anujTutorial.tutorial.DB;
import com.pmtal.anujTutorial.tutorial.DevDB;
import com.pmtal.anujTutorial.tutorial.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
