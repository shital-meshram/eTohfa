package com.app.service;

import java.util.List;

import com.app.pojo.Address;

public interface IAddressService {

	public List<Address> getAllAddress();
	public Address addNewAddress(Address addr);
}
