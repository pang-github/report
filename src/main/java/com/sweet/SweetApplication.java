package com.sweet;

import org.mybatis.spring.annotation.MapperScan;
import org.rockyang.tio.websocket.starter.annotation.EnableTioWebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableAsync //开启异步调用
@EnableScheduling
public class SweetApplication {

    private final static Logger logger = LoggerFactory.getLogger(SweetApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SweetApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        contextPath = contextPath == null ? "" : contextPath;
        String url = "http://localhost:" + port + contextPath;
        logger.info(url);
    }


}
