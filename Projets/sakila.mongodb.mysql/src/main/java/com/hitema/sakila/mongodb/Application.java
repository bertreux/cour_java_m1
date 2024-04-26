package com.hitema.sakila.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Value("${server.port}")
	private Integer port ;

	@Value("${server.servlet.context-path}")
	private String contextPath ;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = String.format("http://localhost:%d%s/check", port, contextPath);
		String swagger = String.format("http://localhost:%d%s/swagger-ui/index.html", port, contextPath);
		log.info("{}",url);
		log.info("{}",swagger);
	}
}
