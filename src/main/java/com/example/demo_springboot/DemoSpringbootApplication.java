package com.example.demo_springboot;

import com.example.demo_springboot.dao.CustomerRepository;
import com.example.demo_springboot.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            System.out.println("#### Test ####");
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("David", "Steve"));
            List<Customer> findByNameSteve = repository.findByLastName("Steve");
            System.out.println(findByNameSteve);
        };
    }
}
