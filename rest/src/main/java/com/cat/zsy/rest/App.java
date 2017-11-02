package com.cat.zsy.rest;

import com.cat.zsy.rest.controller.*;
import com.cat.zsy.rest.util.*;
import io.netty.channel.*;
import org.glassfish.grizzly.http.server.*;
import org.glassfish.jersey.grizzly2.httpserver.*;
import org.glassfish.jersey.jackson.*;
import org.glassfish.jersey.media.multipart.*;
import org.glassfish.jersey.netty.httpserver.*;
import org.glassfish.jersey.server.*;

import java.net.*;

//https://jersey.github.io/documentation/latest/user-guide.html
public class App {

    public static final URI BASE_URI = URI.create("http://localhost:8080/");

    private static void byNetty() {
        try {
            Channel server = NettyHttpContainerProvider.createHttp2Server(BASE_URI, createApp(), null);
            Runtime.getRuntime().addShutdownHook(new Thread(server::close));
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        byNetty();
//        byGrizzly();
    }

    private static void byGrizzly() {
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
            server.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static ResourceConfig2 createApp() {
//        String name = UserController.class.getPackage().getName();
//        return new ResourceConfig()
//                .packages(name)
//                .register(createMoxyJsonResolver());
//    }

    private static ResourceConfig createApp() {
        return new ResourceConfig()
                .packages(App.class.getPackage().getName())
                .register(UserController.class)
                .register(JacksonProvider.class)
                .register(JacksonFeature.class)
                .register(MultiPartFeature.class);
    }

//    private static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
//        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
//        Map<String, String> namespacePrefixMapper = new HashMap<>(1);
//        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
//        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
//        return moxyJsonConfig.resolver();
//    }
}