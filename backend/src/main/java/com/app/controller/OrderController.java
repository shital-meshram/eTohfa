package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerOrderDTO;
import com.app.dto.OrderDto;
import com.app.pojo.Customers;
import com.app.pojo.Order;
import com.app.pojo.Products;
import com.app.repository.OrderRepository;
import com.app.service.IOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Order> DisplayAllOrders()
	{
		return orderService.DisplayAllOrder();
	}
	
	@GetMapping("/{oId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Order GetOrderById(@PathVariable int oId)
	{
		return orderRepo.findByOrderId(oId);
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> PlaceNewOrder(@RequestBody CustomerOrderDTO custOrder)
	{
		try {
			Order order = new Order();
			order.setProducts(custOrder.getProduct());
			order.setCustomer(custOrder.getCustomer());
			orderRepo.save(order);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		} catch (Exception e) {
	      e.printStackTrace();
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("totalamount/{orderId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getTotalAmount(@PathVariable int orderId)
	{
		try {
			Integer totalPrice=orderService.CalculateTotalAmount(orderId);
			return new ResponseEntity<>(totalPrice, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		System.out.println("in del Order "+id);
        return orderService.CancelOrder(id);
	}

}
