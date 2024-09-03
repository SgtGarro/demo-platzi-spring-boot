package com.demo.demo_platzi.web.controller;

import com.demo.demo_platzi.domain.OrderDTO;
import com.demo.demo_platzi.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<OrderDTO>> getByClient(@PathVariable("id") String clientId) {
        return orderService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO purchase) {
        return new ResponseEntity<>(orderService.save(purchase), HttpStatus.CREATED);
    }
}
