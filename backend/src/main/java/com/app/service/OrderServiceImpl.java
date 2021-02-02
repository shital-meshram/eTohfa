package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Customers;
import com.app.pojo.Order;
import com.app.pojo.Products;
import com.app.repository.CustomerRepository;
import com.app.repository.OrderRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    
	@Autowired
	  private OrderRepository orderRepo;
	
	@Override
	public List<Order> DisplayAllOrder() {
		List<Order> list=orderRepo.findAll() ;
		if(list!=null)
			return list;
		return null;
	}

	@Override
	public Order findByCustomer(int custId) {
		return orderRepo.findByCustomer(custId);
	}

	@Override
	public Order PlaceOrder(Order order) {
		Order newOrder=new Order();
		newOrder.setProducts(order.getProducts());
		newOrder.setCustomer(order.getCustomer());
		
		return orderRepo.save(newOrder);
	}

	@Override
	public Order UpdateOrder(int id, Order newOrder) {
		    Order o=orderRepo.findByOrderId(id);
		    if(o!=null)
		    {
		    o.setProducts(newOrder.getProducts());
		    o.setCustomer(newOrder.getCustomer());
		    return orderRepo.save(o);
		    }
		    return null;
	}

	@Override
	public String CancelOrder(int id) {
		orderRepo.deleteById(id);
		return "Order with ID="+id+" Cancelled...";

	}

	@Override
	public Integer CalculateTotalAmount(int id) {
		Optional<Order> o =orderRepo.findById(id);
		int totalPrice=0;
		if(o.isPresent())
		{
			for (Products order : o.get().getProducts()) {
				totalPrice+=order.getPrice();
			}
			return totalPrice;
			
		}
		return null;
	}

}
