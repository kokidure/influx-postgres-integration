package com.samr.influxdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfluxdbApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(InfluxdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InfluxdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("------------------Service running on localhost:8009------------------");
	}
}
	
	
