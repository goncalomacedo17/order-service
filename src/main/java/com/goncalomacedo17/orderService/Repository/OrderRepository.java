package com.goncalomacedo17.orderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goncalomacedo17.orderService.Domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
