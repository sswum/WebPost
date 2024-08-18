package org.minipost.global.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="file.upload")
public class FileProperties {
    // 파일 업로드와 관련된 설정 / 외부 설정 파일에서 읽어오는 클래스

    private String path;
    private String url;

}
