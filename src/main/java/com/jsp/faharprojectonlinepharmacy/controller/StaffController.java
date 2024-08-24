package com.jsp.faharprojectonlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.faharprojectonlinepharmacy.dto.Staff;
import com.jsp.faharprojectonlinepharmacy.service.StaffService;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveS(@RequestParam int adminId,@RequestParam int storeId,@RequestBody Staff staff)
	{
		return staffService.saveStaff(adminId, storeId, staff);
		
	}
	@PutMapping("/updateStaff")
	public ResponseEntity<ResponseStructure<Staff>> updateS(@RequestParam int id,@RequestBody Staff staff)
	{
		return staffService.updateStaff(id,staff);
	}
	@GetMapping("/findStaff")
	public ResponseEntity<ResponseStructure<Staff>> findS(@RequestParam int id)
	{
		return staffService.findStaff(id);
	}
	@GetMapping("/deleteStaff")
	public ResponseEntity<ResponseStructure<Staff>> deleteS(@RequestParam int id)
	{
		return staffService.deleteStaff(id);
	}

}
