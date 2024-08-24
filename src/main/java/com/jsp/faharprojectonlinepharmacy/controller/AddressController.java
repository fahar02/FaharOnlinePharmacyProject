package com.jsp.faharprojectonlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.faharprojectonlinepharmacy.dto.Address;
import com.jsp.faharprojectonlinepharmacy.service.AddressService;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> save(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> update(@RequestParam int id, @RequestBody Address address)
	{
		return addressService.updateAddress(id,address);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> find(@RequestParam int id)
	{
		return addressService.findbyAddress(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> delete(@RequestParam int id)
	{
		return addressService.deleteAddress(id);
	}

}
