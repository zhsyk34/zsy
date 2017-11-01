package com.cat.zsy.exception.handler;

import com.cat.zsy.exception.Exceptions;

import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper extends AbstractExceptionMapper<Exceptions.MyException> {

}