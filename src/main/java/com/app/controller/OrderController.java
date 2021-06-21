package com.app.controller;

import com.app.model.Car;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Order;
import com.app.service.OrderServiceImpl;
import com.app.service.api.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/find-order-by-id/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("/find-orders-by-status/{statusId}")
    public List<Order> findOrdersByStatus(@PathVariable Long statusId) {
        return orderService.findOrdersByStatus(statusId);
    }

    @PostMapping("/save-order")
    public void saveOrder(@RequestBody Order order) throws Exception {
        orderService.saveOrder(order);
    }

    @GetMapping("/find-all-order")
    public List<Order> findAllOrder() {
        return orderService.findAllOrders();
    }

    @DeleteMapping("/delete-order")
    public void deleteOrder(@RequestBody Order order) {
        orderService.deleteOrder(order);
    }

     @DeleteMapping("/delete-order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    @Autowired
    public void setOrderStatus(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
}
