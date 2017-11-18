//package com.cat.zsy.mvc.config;
//
//import org.springframework.context.annotation.*;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.config.annotation.*;
//
//import java.util.List;
//
//@Configuration
//@EnableWebMvc//<mvc:annotation-driven />
//
//@ComponentScan(
////        basePackageClasses = {FirstController.class},
//        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = Controller.class)}
//)
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    //conversionService:formatter
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//    }
//
//    //<mvc:annotation-driven conversion-service>
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    }
//
//    //<mvc:interceptors>
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//    }
//
//    //<mvc:annotation-driven content-negotiation-manager>
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false).favorParameter(true);
//    }
//
//    //<mvc:view-controller path="/" view-name="home"/>
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("home");
//    }
//
//    //<mvc:resources mapping="/resources/**" location="/public-resources/"/>
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/public-resources/")
//                .setCachePeriod(1 << 10);
//    }
//
//    //<mvc:default-servlet-handler/>
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//}
