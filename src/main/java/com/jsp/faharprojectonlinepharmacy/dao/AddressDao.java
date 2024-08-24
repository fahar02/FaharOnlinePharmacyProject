package com.jsp.faharprojectonlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.faharprojectonlinepharmacy.dto.Address;
import com.jsp.faharprojectonlinepharmacy.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepo addressRepo;
	
	public Address addressSave(Address address)
	{
		return addressRepo.save(address);
	}
	public Address addressUpdate(int id, Address address)
	{
		Optional<Address> optional=addressRepo.findById(id);
		if(optional.isPresent())
		{
			address.setAddressId(id);
		return addressRepo.save(address);
			 
		}
		return null;
	}
	
	public Address findAddress(int id)
	{
		Optional<Address> optional=addressRepo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Address addressDelete(int id)
	{
		Optional<Address> optional=addressRepo.findById(id);
		if(optional.isPresent())
		{
			
			addressRepo.delete(optional.get());
			return optional.get();
			
		}
		return null;
		
	}

}
