package com.app.dto;

import java.util.List;

import com.app.pojo.Customers;
import com.app.pojo.Products;

public class CustomerOrderDTO {
	public List<Products> product;
	public Customers customer;
	public List<Products> getProduct() {
		return product;
	}
	public void setProduct(List<Products> product) {
		this.product = product;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
}
