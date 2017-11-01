package com.cat.zsy.exception.handler;

import com.cat.zsy.exception.Exceptions;

import javax.ws.rs.ext.Provider;

@Provider
public class MySubExceptionMapper extends AbstractExceptionMapper<Exceptions.MySubException> {

}