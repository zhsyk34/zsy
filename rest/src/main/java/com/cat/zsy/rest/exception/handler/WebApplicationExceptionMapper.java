package com.cat.zsy.rest.exception.handler;

import com.cat.zsy.rest.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response toResponse(WebApplicationException exception) {
        logger.info("--------------exception", exception);
        logger.debug("-------------handle by class:{}", getClass().getName());
        Response response = exception.getResponse();

        return Response.status(response.getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(Result.error(Status.fromStatusCode(response.getStatus())))
                .build();
    }
}