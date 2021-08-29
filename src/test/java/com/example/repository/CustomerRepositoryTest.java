package com.example.repository;

import com.example.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {CustomerRepository.class})
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Sql({"/two_users.sql"})
    void findAll_2users() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        assertEquals(2, customers.size());
    }

    @Test
    @Sql({"/three_users.sql"})
    void findAll_3users() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        assertEquals(3, customers.size());
    }
}