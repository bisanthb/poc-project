package com.sams.oms.controllers;

import com.sams.oms.model.OrderDetail;
import com.sams.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oms/order")
public class FulfillmentController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    ResponseEntity<?> processOrder(@PathVariable("orderId") String orderId) {
        OrderDetail orderDetail = new OrderDetail(orderId, "INPROGRESS");
        return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    ResponseEntity<?> getOrderStatus(@PathVariable("orderId") String orderId) {
        OrderDetail orderDetail = new OrderDetail(orderId, "INPROGRESS");
        return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.OK);
    }
}