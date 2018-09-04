package ru.sergio.testmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.sergio.testmvc.dto.Order;
import ru.sergio.testmvc.dto.Product;
import ru.sergio.testmvc.dto.ResponseDto;
import ru.sergio.testmvc.exception.WrongFormatException;
import ru.sergio.testmvc.service.TestMvcService;

import java.util.List;

@RestController
@RequestMapping("/testMvc/1/order")
public class TestMvcController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMvcController.class);

    private TestMvcService service;

    public TestMvcController(TestMvcService service) {
        this.service = service;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> processOrders(@RequestBody Order order) throws WrongFormatException {

        if (StringUtils.isEmpty(order.getCustomer()) || order.getCustomer().length() > 9) {
            throw new WrongFormatException("Customer id is incorrect or absent");
        }
        if (StringUtils.isEmpty(order.getSeller()) || order.getSeller().length() > 9) {
            throw new WrongFormatException("Seller id is incorrect or absent");
        }
        checkProducts(order.getProducts());
        return ResponseEntity.ok().body(service.processOrder(order));
    }

    private void checkProducts(List<Product> products) {
        if (CollectionUtils.isEmpty(products)) {
            throw new WrongFormatException("Product list is absent");
        }
        for (Product product : products) {
            if (StringUtils.isEmpty(product.getCode()) || product.getCode().length() > 13) {
                throw new WrongFormatException("Product code is incorrect");
            }
            if (StringUtils.isEmpty(product.getCode())) {
                throw new WrongFormatException("Product name is required");
            }
        }
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDto> unrecognizedParameterHandler(WrongFormatException e) {
        LOGGER.error("Format input parameter is wrong with message: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(e.getMessage()));
    }

}
