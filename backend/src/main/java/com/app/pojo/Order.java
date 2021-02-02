package com.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.pojo.Products;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name="orders")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.REFRESH
			, CascadeType.MERGE}) //mandatory : if not supplied hibernate throws MappingExc.
	@JoinTable(name="order_product",joinColumns = @JoinColumn(name="order_id"),
	inverseJoinColumns = @JoinColumn(name="product_id"))
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Products> products=new ArrayList<>();
	
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="customerId")
	private Customers customer;
	
	/*@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "order")
	private OrderDetails orderdetails;*/
	
	public Order()
	{
		System.out.println("Default order constr");
	}

	public Order(Integer orderId, List<Products> products, Customers customer) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.customer = customer;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
