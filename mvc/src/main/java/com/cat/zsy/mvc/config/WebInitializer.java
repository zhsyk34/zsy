//package com.cat.zsy.mvc.config;
//
//import org.springframework.web.*;
//import org.springframework.web.context.*;
//import org.springframework.web.context.support.*;
//import org.springframework.web.filter.*;
//import org.springframework.web.servlet.*;
//
//import javax.servlet.*;
//import java.nio.charset.*;
//
//public class WebInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(WebConfig.class);
//        ctx.setServletContext(servletContext);
//
//        //encoding
//        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter(CharacterEncodingFilter.class.getSimpleName(), new CharacterEncodingFilter());
//        characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
//        characterEncodingFilter.setInitParameter("encoding", StandardCharsets.UTF_8.name());
//        characterEncodingFilter.setInitParameter("forceEncoding", Boolean.valueOf(true).toString());
//
//        // 配置分发器
//        ServletRegistration.Dynamic dynamic = servletContext.addServlet(DispatcherServlet.class.getSimpleName(), new DispatcherServlet(ctx));
//        dynamic.addMapping("/");
//        dynamic.setLoadOnStartup(1);
//        // Spring容器监听
//        servletContext.addListener(new ContextLoaderListener(ctx));
//    }
//
//}