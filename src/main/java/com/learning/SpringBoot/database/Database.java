package com.learning.SpringBoot.database;

import com.learning.SpringBoot.models.Product;
import com.learning.SpringBoot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration //include Bean method => create database ...
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    //interface CommandLineRunner
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product1 = new Product ("iPhone 13 Pro", 2020, 1399.0, "");
                Product product2 = new Product("Samsung Galaxy S22", 2022, 1399.0, "");
                logger.info("insert data: "+productRepository.save(product1));
                logger.info("insert data: "+productRepository.save(product2));
            }
        };
    }

}
