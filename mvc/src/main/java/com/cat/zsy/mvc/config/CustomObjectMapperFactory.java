package com.cat.zsy.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomObjectMapperFactory {

    public static ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule()
                .addSerializer(new PageSerializer());

        mapper.registerModule(module);

        return mapper;
    }
}
