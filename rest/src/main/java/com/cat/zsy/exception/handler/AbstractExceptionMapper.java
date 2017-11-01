package com.cat.zsy.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public abstract class AbstractExceptionMapper<E extends Throwable> implements ExceptionMapper<E> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response toResponse(E exception) {
        logger.debug("------------handle by class:{}", getClass().getName(), exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(getClass().getSimpleName() + ":" + exception.getMessage())
                .build();
    }
}
