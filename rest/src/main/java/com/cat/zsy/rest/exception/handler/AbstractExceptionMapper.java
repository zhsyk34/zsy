package com.cat.zsy.rest.exception.handler;

import com.cat.zsy.rest.dto.*;
import org.slf4j.*;

import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;
import javax.ws.rs.ext.*;

public abstract class AbstractExceptionMapper<E extends Throwable> implements ExceptionMapper<E> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response toResponse(E exception) {
        logger.debug(">>>>>>>>>>>{} handle by class:{}", exception, getClass().getName());

        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON)
                .entity(Result.error(Status.INTERNAL_SERVER_ERROR, getClass().getName()))
                .build();
    }
}
