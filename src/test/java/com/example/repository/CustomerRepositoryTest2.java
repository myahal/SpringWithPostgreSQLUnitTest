package com.example.repository;

import com.example.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {CustomerRepository.class})
class CustomerRepositoryTest2 {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void findAll_2users() {
        jdbcTemplate.execute(loadSQL("classpath:two_users.sql"));
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        assertEquals(2, customers.size());
    }

    @Test
    void findAll_3users() {
        jdbcTemplate.execute(loadSQL("classpath:three_users.sql"));
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        assertEquals(3, customers.size());
    }

    private String loadSQL(String fileName) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(fileName);
        try ( Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}