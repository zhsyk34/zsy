package com.cat.zsy.rest.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@PreMatching
@Provider
public class BaseRequestFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.debug("-----------filter:{}", getClass().getSimpleName());

        logger.debug(
                "uri:{}, method:{}, media:{}, params:{}",
                requestContext.getUriInfo().getAbsolutePath(),
                requestContext.getMethod(),
                requestContext.getMediaType(),
                requestContext.getUriInfo().getQueryParameters()
        );
    }
}
