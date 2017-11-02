//package com.cat.zsy.exception;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.Response;
//
//@Path("exception")
//@Consumes("text/plain")
//@Produces("text/plain")
//public class ExceptionResource {
//
//    @GET
//    public String pingMe() {
//        System.out.println("----------------ping----------------");
//        return "ping!";
//    }
//
//    @POST
//    @Path("webapplication_entity")
//    public String testWebApplicationExceptionEntity(String s) {
//        String[] tokens = s.split(":");
//        assert tokens.length == 2;
//        int statusCode = Integer.valueOf(tokens[1]);
//        Response r = Response.status(statusCode).entity(s).build();
//        throw new WebApplicationException(r);
//    }
//
//    @POST
//    @Path("webapplication_noentity")
//    public String testWebApplicationExceptionNoEntity(String s) {
//        String[] tokens = s.split(":");
//        assert tokens.length == 2;
//        int statusCode = Integer.valueOf(tokens[1]);
//        Response r = Response.status(statusCode).build();
//        throw new WebApplicationException(r);
//    }
//
//    @POST
//    @Path("my")
//    public String testMyException(String s) {
//        System.out.println("--------my==============");
//        String[] tokens = s.split(":");
//        int statusCode = Integer.valueOf(tokens[1]);
//        Response r = Response.status(statusCode).build();
//        System.out.println("my end==============");
//        throw new Exceptions.MyException(r);
//    }
//
//    @POST
//    @Path("mysub")
//    public String testMySubException(String s) {
//        String[] tokens = s.split(":");
//        assert tokens.length == 2;
//        int statusCode = Integer.valueOf(tokens[1]);
//        Response r = Response.status(statusCode).build();
//        throw new Exceptions.MySubException(r);
//    }
//
//    @POST
//    @Path("mysubsub")
//    public String testMySubSubException(String s) {
//        String[] tokens = s.split(":");
//        assert tokens.length == 2;
//        int statusCode = Integer.valueOf(tokens[1]);
//        Response r = Response.status(statusCode).build();
//        throw new Exceptions.MySubSubException(r);
//    }
//
//    @POST
//    @Path("request_exception")
//    public String exceptionInRequestFilter() {
//        throw new InternalServerErrorException();        // should not reach here
//    }
//
//    @GET
//    @Path("response_exception")
//    public String exceptionInResponseFilter() {
//        return "Response Exception";
//    }
//}
