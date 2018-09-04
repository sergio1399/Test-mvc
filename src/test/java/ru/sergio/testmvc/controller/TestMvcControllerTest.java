package ru.sergio.testmvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.sergio.testmvc.service.TestMvcService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestMvcController.class)
public class TestMvcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProcessOrders() throws Exception {
        this.mockMvc.perform(post("/testMvc/1/order")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{\n" +
                        "\"seller\":\"123534251\",\n" +
                        "\"customer\":\"648563524\",\n" +
                        "\"products\":[{\"name\":\"milk\",\"code\":\"2364758363546\"},{\"name\":\"water\",\"code\":\"3656352437590\"}]\n" +
                        "}")).andExpect(status().is2xxSuccessful());
    }

}