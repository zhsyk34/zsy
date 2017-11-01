package com.cat.zsy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * TODO:just for client?
 */
@Provider
public class FirstRequestFilter implements ClientRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        logger.debug("----------uri:{}, method:{}, media:{}", requestContext.getUri(), requestContext.getMethod(), requestContext.getMediaType());
    }
}
