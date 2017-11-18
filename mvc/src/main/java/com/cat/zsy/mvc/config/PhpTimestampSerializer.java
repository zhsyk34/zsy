package com.cat.zsy.mvc.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.experimental.var;

import java.io.IOException;

public class PhpTimestampSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        var time = value * 1000;
//        LocalDateTime.
        gen.writeRawValue("");
    }
}
