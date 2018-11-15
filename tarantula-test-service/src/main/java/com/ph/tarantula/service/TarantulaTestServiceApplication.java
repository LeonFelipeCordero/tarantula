package com.ph.tarantula.service;

import com.ph.tarantula.service.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class TarantulaTestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TarantulaTestServiceApplication.class, args);
    }
}
