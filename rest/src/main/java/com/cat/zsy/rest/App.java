package com.cat.zsy.rest;

import com.cat.zsy.rest.util.JacksonProvider;
import io.netty.channel.Channel;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

//https://jersey.github.io/documentation/latest/user-guide.html
public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/");

    public static void main(String[] args) {
        byNetty();
//        byGrizzly();
    }

    private static void byNetty() {
        try {
            Channel server = NettyHttpContainerProvider.createHttp2Server(BASE_URI, config(), null);
            Runtime.getRuntime().addShutdownHook(new Thread(server::close));
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void byGrizzly() {
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
            server.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ResourceConfig config() {
        return new ResourceConfig()
                .packages(App.class.getPackage().getName())
                .register(JacksonProvider.class)
                .register(JacksonFeature.class)
                .register(MultiPartFeature.class);
    }

}