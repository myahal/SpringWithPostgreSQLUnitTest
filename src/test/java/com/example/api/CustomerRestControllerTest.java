package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
class CustomerRestControllerTest {
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerRestController customerRestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCustomers() throws Exception{
        List<Customer> customers = List.of(
                new Customer(1, "Ray", "Ayanami"),
                new Customer(2, "Asuka", "Langray"),
                new Customer(3, "Shinji", "Ikari")
        );
        Mockito.when(customerRestController.getCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", equalTo("Ray")))
                .andExpect(jsonPath("$[0].lastName", equalTo("Ayanami")));
    }
}