package org.minipost.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") //정적 경로 위치 찾아주는 것
                .addResourceLocations("classpath:/static/");
    }
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
