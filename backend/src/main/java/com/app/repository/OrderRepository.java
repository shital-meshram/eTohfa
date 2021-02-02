package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{      Order findByOrderId(Integer id);
       Order findByCustomer(int  custId);
       Order findByProducts(int id);
}
