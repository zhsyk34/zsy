package com.cat.zsy.rest.filter;

import org.slf4j.*;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.*;
import java.io.*;

@Provider
public class CustomResponseFilter implements ContainerResponseFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String name = this.getClass().getSimpleName();

        logger.debug("enter response filter:{}", name);

        logger.debug("return result:{}", responseContext.getEntity());

        logger.debug("exit response filter:{}", name);
    }

}