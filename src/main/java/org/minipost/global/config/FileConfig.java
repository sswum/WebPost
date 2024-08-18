package org.minipost.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@EnableConfigurationProperties(FileProperties.class)
@Configuration
public class FileConfig implements WebMvcConfigurer {
    //정적 경로와 실제 파일 경로와 웹에서 접근할 수 있도록.

    private final FileProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // url 경로 지정  => /files/myfile.jpg 접근하면 밑에 위치로 파일 제공!
        registry.addResourceHandler(properties.getUrl() + "**")
                // 실제 파일이 저장된 경로를 지정
                .addResourceLocations("file:///" + properties.getPath());

    }
}
