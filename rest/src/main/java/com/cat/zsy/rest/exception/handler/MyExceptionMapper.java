package com.cat.zsy.rest.exception.handler;

import com.cat.zsy.rest.exception.*;

import javax.ws.rs.ext.*;

@Provider
public class MyExceptionMapper extends AbstractExceptionMapper<Exceptions.MyException> {

}