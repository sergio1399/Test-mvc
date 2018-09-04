package ru.sergio.testmvc.service;

import ru.sergio.testmvc.dto.Order;
import ru.sergio.testmvc.dto.ResponseDto;

public interface TestMvcService {

    ResponseDto processOrder(Order order);

}
