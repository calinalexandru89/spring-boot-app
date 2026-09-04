package com.loocos;

import com.loocos.customer.Customer;
import com.loocos.customer.CustomerRepository;
import com.loocos.customer.Gender;
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
            int age = random.nextInt(16, 99);
            Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
                        Customer customer = new Customer( firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    age, gender);

            customerRepository.save(customer);
        };
    }
}
