package com.cat.zsy.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Configuration
@Import(BeanConfig.class)
public class BeanConfig {

    @Bean
    PageableArgumentResolver pageableArgumentResolver() {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setFallbackPageable(new PageRequest(0, 3, DESC, "id"));
        return resolver;
    }

    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter converter(PageSerializer pageSerializer) {
        System.err.println(pageSerializer);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule().addSerializer(pageSerializer));
        return new MappingJackson2HttpMessageConverter(mapper);
    }
}
