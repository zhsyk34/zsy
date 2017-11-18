package com.cat.zsy.rest.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Priority(Priorities.USER)
@Provider
public class OneRequestFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        logger.debug("-----------filter:{}", getClass().getSimpleName());

    }
}
