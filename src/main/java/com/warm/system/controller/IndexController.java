package com.warm.system.controller;


import com.warm.system.entity.Order;
import com.warm.system.entity.User;
import com.warm.system.service.db1.UserService;
import com.warm.system.service.db2.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@RestController
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getOrderList() {
        return ResponseEntity.ok(orderService.getOrderList());
    }
    @GetMapping("/price")
    public ResponseEntity<BigDecimal> getPrice() {
        return ResponseEntity.ok(orderService.getOrderPriceByUserId(1));
    }
    @GetMapping("/price2")
    public ResponseEntity<BigDecimal> getPrice2() {
        return ResponseEntity.ok(userService.getOrderPriceByUserId(1));
    }
}

