package com.cat.zsy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CustomResponseFilter implements ContainerResponseFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String name = this.getClass().getSimpleName();

        logger.debug("enter filter:{}", name);

        logger.debug("----------uri:{}, method:{}, media:{}", requestContext.getUriInfo().getAbsolutePath(), requestContext.getMethod(), requestContext.getMediaType());

        //responseContext.setEntity(responseContext.getEntity() + ":" + name, null, MediaType.TEXT_PLAIN_TYPE);

        logger.debug("exit filter:{}", name);
    }

}