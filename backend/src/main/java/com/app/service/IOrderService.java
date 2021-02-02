package com.app.service;

import java.util.List;

import com.app.pojo.Customers;
import com.app.pojo.Order;
import com.app.pojo.Products;

public interface IOrderService {
	List<Order> DisplayAllOrder();
	Order findByCustomer(int custId);
	Order PlaceOrder(Order order);
	Order UpdateOrder(int id,Order newOrder);
	String CancelOrder(int id);
	Integer CalculateTotalAmount(int id);
	
	

}
