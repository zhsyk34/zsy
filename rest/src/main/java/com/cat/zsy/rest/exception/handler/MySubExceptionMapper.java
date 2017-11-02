package com.cat.zsy.rest.exception.handler;

import com.cat.zsy.rest.exception.*;

import javax.ws.rs.ext.*;

@Provider
public class MySubExceptionMapper extends AbstractExceptionMapper<Exceptions.MySubException> {

}