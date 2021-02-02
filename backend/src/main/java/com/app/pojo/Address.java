package com.app.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer addId;
	@Column(name="plot_no")
	private String plotNo;
	@Column(length=30)
	private String city;
	@Column(length=30)
	private String state;
	@Column(length=30)
	private String country;
	@NotBlank(message="Postal code must be provided")
	private String postalCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public Address(Integer addId, String plotNo, String city, String state, String country,
			@NotBlank(message = "Postal code must be provided") String postalCode) {
		super();
		this.addId = addId;
		this.plotNo = plotNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}





	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	//toString
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", plotNo=" + plotNo + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + "]";
	}

	
	
	
}
