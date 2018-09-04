package ru.sergio.testmvc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.sergio.testmvc.dto.Order;
import ru.sergio.testmvc.dto.ResponseDto;
import ru.sergio.testmvc.service.TestMvcService;

@Service
public class TestMvcServiceImpl implements TestMvcService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMvcServiceImpl.class);
    @Override
    public ResponseDto processOrder(Order order) {
        LOGGER.info("Processing order...");
        //TODO logic for processing orders
        return new ResponseDto(true);
    }

}
