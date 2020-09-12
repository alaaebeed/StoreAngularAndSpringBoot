package com.alaa.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alaa.product.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class SpringBootUploadDownloadFileRestApiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadDownloadFileRestApiExampleApplication.class, args);
    }
}
