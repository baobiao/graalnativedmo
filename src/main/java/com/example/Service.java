package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service 
{
    private static Logger LOGGER = LoggerFactory.getLogger(Service.class);

    public static void main( String[] args )
    {
        LOGGER.info("Start - main()");
        SpringApplication.run(Service.class, args);
        LOGGER.info("End - main()");
    }
}
