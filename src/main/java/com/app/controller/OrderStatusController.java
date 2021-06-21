package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderStatus;
import com.app.service.OrderStatusServiceImpl;
import com.app.service.api.OrderStatusService;

@RestController
@RequestMapping("/order_status")
public class OrderStatusController {
    private OrderStatusService orderStatusService;


    @GetMapping("/find-order-status-by-id/{id}")
    public OrderStatus findOrderStatusById(@PathVariable Long id) {
        return orderStatusService.findOrderStatusById(id);
    }

    @PostMapping("/save-order-status")
    public void addOrderStatus(@RequestBody OrderStatus orderStatus) {
        orderStatusService.addOrderStatus(orderStatus);
    }

    @GetMapping("/find-all-order-status")
    public List<OrderStatus> findAllOrderStatus () {
        return orderStatusService.findAllOrderStatuses();
    }

    @DeleteMapping("/delete-order-status")
    public void deleteOrderStatus (@RequestBody OrderStatus orderStatus) {
        orderStatusService.deleteOrderStatus(orderStatus);
    }

     @DeleteMapping("/delete-order-status-by-id/{id}")
    public void deleteOrderStatus(@PathVariable Long id) {
        orderStatusService.deleteOrderStatusById(id);
    }

    @Autowired
    public void setOrderStatus(OrderStatusServiceImpl orderStatusService) {
        this.orderStatusService = orderStatusService;
    }
}
