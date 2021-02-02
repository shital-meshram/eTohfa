package com.app.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="customers")
public class Customers implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer custId; 
	
 	@Column(name="first_name")
 	@NotBlank(message = "First Name must be supplied")
 	private String fname;
 	
 	@Column(name="last_name")
 	@NotBlank(message = "Last Name must be supplied")
 	private String lname; 
	 
 	@Column (length = 30, unique = true)
	@NotBlank(message="Email must be provided")
	private String email;
	
 	@NotNull
	@Size(min = 2, max = 30)
	private String password;
 	//address (foreign key)
 	
 	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 	@OneToOne(targetEntity = Address.class ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 	@JoinColumn(name = "addr_id", referencedColumnName = "id")
 	private Address address;
 	
 	
 	
 	public Customers() {
		// TODO Auto-generated constructor stub
	}
 	
 	
 	public Customers(Integer custId, @NotBlank(message = "First Name must be supplied") String fname,
			@NotBlank(message = "Last Name must be supplied") String lname,
			@NotBlank(message = "Email must be provided") String email, @Size(min = 2, max = 30) String password) {
		super();
		this.custId = custId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}


	//setters getters
	public Integer getId() {
		return custId;
	}

	public void setId(Integer id) {
		this.custId = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customers [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	//toString

	

	
	
 	
 	
	
}
