package com.cat.zsy.rest.exception.handler;

import com.cat.zsy.rest.dto.*;
import org.slf4j.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;
import javax.ws.rs.ext.*;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response toResponse(WebApplicationException exception) {
        logger.debug(">>>>>>>>>>>{} handle by class:{}", exception, getClass().getName());
        Response response = exception.getResponse();

        logger.info("exception:{}", exception);

        return Response.status(response.getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(Result.error(Status.fromStatusCode(response.getStatus())))
                .build();
    }
}