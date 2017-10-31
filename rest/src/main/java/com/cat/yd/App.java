package com.cat.yd;

import com.cat.yd.route.UserResource;
import io.netty.channel.Channel;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ext.ContextResolver;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/");

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
    }

    public static void byGrizzly() {
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
            server.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ResourceConfig createApp() {
        String name = UserResource.class.getPackage().getName();
        return new ResourceConfig()
                .packages(name)
                .register(createMoxyJsonResolver());
    }

    private static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }
}