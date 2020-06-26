package com.atguigu.crowd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.atguigu",includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},useDefaultFilters = false)
public class WebConfig extends WebMvcConfigurerAdapter {

    //静态拦截器
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
         configurer.enable();
    }

    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views", ".jsp");
    }
}
