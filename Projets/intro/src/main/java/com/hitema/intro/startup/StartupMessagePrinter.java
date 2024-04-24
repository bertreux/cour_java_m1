package com.hitema.intro.startup;

import com.hitema.intro.controllers.CountryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupMessagePrinter implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:" + serverPort + contextPath + "/check";
        log.info("(url): {}", url);
    }
}
