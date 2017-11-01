package com.cat.zsy.filter;

import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class WebApplicationExceptionFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String name = getClass().getSimpleName();

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        logger.debug("enter pre filter:{}", name);

        String path = ((ContainerRequest) context).getRequestUri().getPath();
        if (path.endsWith("request_exception") && context.hasEntity() && ((ContainerRequest) context)
                .readEntity(String.class).equals("Request Exception")) {
            throw new WebApplicationException(Response.Status.OK);
        }

        logger.debug("exit pre filter:{}", name);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        logger.debug("enter post filter:{}", name);

        if (responseContext.hasEntity() && responseContext.getEntity().equals("Response Exception")) {
            throw new WebApplicationException(Response.Status.OK);
        }

        logger.debug("exit post filter:{}", name);
    }
}
