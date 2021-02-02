package com.app.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer credentialId;
	
	private String username;
	
	private String password;
	
	@Column(name="loginTime")
	private Date date;
	
	public Credentials() {
		// TODO Auto-generated constructor stub
	}

	public Credentials(Integer credentialId, String username, String password, Date date) {
		super();
		this.credentialId = credentialId;
		this.username = username;
		this.password = password;
		this.date = date;
	}

	public Integer getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Credentials [credentialId=" + credentialId + ", username=" + username + ", password=" + password
				+ ", date=" + date + "]";
	}
	
	
	
	
}
