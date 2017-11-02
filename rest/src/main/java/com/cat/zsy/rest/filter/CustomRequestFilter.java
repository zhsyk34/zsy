package com.cat.zsy.rest.filter;

import org.slf4j.*;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.*;
import java.io.*;

@Provider
public class CustomRequestFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String name = getClass().getSimpleName();

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        logger.debug("enter request filter:{}", name);

        logger.debug(
                "----------uri:{}, method:{}, media:{}, params:{}",
                context.getUriInfo().getAbsolutePath(),
                context.getMethod(),
                context.getMediaType(),
                context.getUriInfo().getQueryParameters()
        );

        logger.debug("exit request filter:{}", name);
    }
}
