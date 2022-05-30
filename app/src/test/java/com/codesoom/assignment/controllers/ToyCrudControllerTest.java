package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.ToyCrudService;
import com.codesoom.assignment.domain.ImageDemo;
import com.codesoom.assignment.domain.Toy;
import com.codesoom.assignment.domain.ToyProducer;
import com.codesoom.assignment.domain.Won;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ToyCrudController")
class ToyCrudControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ToyCrudService service;

    private final List<Toy> toys = new LinkedList<>();

    private Toy toy;
    private ToyProducer producer;
    private Won money;
    private ImageDemo demo;
    private final String PRODUCT_NAME = "Test Product";
    private final String PRODUCER_NAME = "Test Producer";
    private final BigDecimal MONEY_VALUE = new BigDecimal(1000);
    private final String IMAGE_URL = "https://metacode.biz/@test/avatar.jpg";

    @BeforeEach
    void setUp() {
        demo = new ImageDemo(IMAGE_URL);
        money = new Won(MONEY_VALUE);

        producer = ToyProducer.builder()
                .name(PRODUCER_NAME)
                .build();
        toy = Toy.builder()
                .name(PRODUCT_NAME)
                .price(money)
                .producer(producer)
                .demo(demo)
                .build();
    }

    @AfterEach
    void clear() {
        toys.clear();
    }

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list {
        @BeforeEach
        void setUp() {
            given(service.showAll()).willReturn(List.of(toy));
        }

        @Test
        @DisplayName("HTTP Status Code 200 OK 응답한다")
        void it_responds_with_200_ok() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(PRODUCT_NAME)));
        }
    }
}
