package com.cat.zsy.rest.util;

import com.fasterxml.jackson.databind.*;

import javax.ws.rs.ext.*;

@Provider
public class JacksonProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper = createDefaultMapper();

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

    private static ObjectMapper createDefaultMapper() {
        ObjectMapper result = new ObjectMapper();
        result.enable(SerializationFeature.INDENT_OUTPUT);
        return result;
    }
}