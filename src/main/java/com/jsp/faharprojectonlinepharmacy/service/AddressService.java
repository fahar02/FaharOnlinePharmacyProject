package com.jsp.faharprojectonlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.faharprojectonlinepharmacy.dao.AddressDao;
import com.jsp.faharprojectonlinepharmacy.dto.Address;
import com.jsp.faharprojectonlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		Address addressdb=addressDao.addressSave(address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setMessage("address save successfully");
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setData(addressdb);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address)
	{
		Address dbAddress=addressDao.addressUpdate(id,address);
		if(dbAddress!=null)
		{
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("address update Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new AddressIdNotFoundException("address id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Address>> findbyAddress(int id)
	{
		Address address=addressDao.findAddress(id);
		if(address!=null)
		{
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("address update Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new AddressIdNotFoundException("address id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id)
	{
		Address address=addressDao.addressDelete(id);
		if(address!=null)
		{
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("address delete Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new AddressIdNotFoundException("address id not found");
		}
		
	}

}
