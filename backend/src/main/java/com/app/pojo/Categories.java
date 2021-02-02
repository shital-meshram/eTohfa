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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer catId;
	@Column (length = 30, unique = true)
	private String catName;
	@Column (length = 30)
	private String brand;
	
	 public Categories() {
		// TODO Auto-generated constructor stub
		 System.out.println("category constr");
	}
	
	//@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy ="category")
	//private List<Products> products=new ArrayList<Products>();
	
	
	

	public Integer getCatId() {
		return catId;
	}

	public Categories(Integer catId, String catName, String brand) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.brand = brand;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Categories [catId=" + catId + ", catName=" + catName + ", brand=" + brand + "]";
	}
	
	
	
	
}
