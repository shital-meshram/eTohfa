package com.app.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer prodId;
	
	@Column (name="product_name",length = 30)
	private String prodName;
	
	@Column (length = 300)
	private String description;
	
	private Double price;
	
	@Lob
	private byte[] image;
	
	@Column(length = 30)
	private String imageContent;
	
	private Integer quantity;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity = Categories.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Categories category;
	
	@ManyToMany(mappedBy ="products",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Order> orders=new ArrayList<>();
	
	public Products()
	{
		System.out.println("product Default constructor");
	}

	public Products(Integer prodId, String prodName, String description, Double price, byte[] image,
			String imageContent, Integer quantity, Categories category) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.description = description;
		this.price = price;
		this.image = image;
		this.imageContent = imageContent;
		this.quantity = quantity;
		this.category = category;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageContent() {
		return imageContent;
	}

	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Products [prodId=" + prodId + ", prodName=" + prodName + ", description=" + description + ", price="
				+ price + ", image=" + Arrays.toString(image) + ", imageContent=" + imageContent + ", quantity="
				+ quantity + ", category=" + category + "]";
	}
	

	

	
	

}
