package com.jth.rest.restservices;

import java.util.Set;

import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.jth.rest.restservices.data.RestEntity;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    	Reflections reflections = new Reflections("com.jth.rest.restservices.data.domain");
    	Set<Class<? extends RestEntity>> restEntities = reflections.getSubTypesOf(RestEntity.class);
    	for(Class<? extends RestEntity> entity : restEntities) {
    		config.exposeIdsFor(entity);
    	}
    }
}
