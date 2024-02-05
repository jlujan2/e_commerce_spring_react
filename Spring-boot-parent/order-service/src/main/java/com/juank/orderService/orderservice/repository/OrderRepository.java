package com.juank.orderService.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juank.orderService.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
