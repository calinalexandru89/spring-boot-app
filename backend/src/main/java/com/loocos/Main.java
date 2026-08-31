package com.loocos;

import com.loocos.customer.Customer;
import com.loocos.customer.CustomerRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Random;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {


        var faker = new Faker();
        Random random = new Random();
        var name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        return args -> {
            Customer customer = new Customer( firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(16,99));

            customerRepository.save(customer);
        };
    }
}
