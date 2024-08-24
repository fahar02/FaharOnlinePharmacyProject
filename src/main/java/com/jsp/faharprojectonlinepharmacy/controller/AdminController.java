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

import com.jsp.faharprojectonlinepharmacy.dto.Admin;
import com.jsp.faharprojectonlinepharmacy.service.AdminService;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseStructure<Admin>> save(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Admin>> update(@RequestParam int id, @RequestBody Admin admin)
	{
		return adminService.updateAdmin(id,admin);
	}
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Admin>> find(@RequestParam int id )
	{
		return adminService.findAdmin(id);
	}
	@GetMapping("/findbyemail")
	public ResponseEntity<ResponseStructure<Admin>> findEmail(@RequestParam String email)
	{
		return adminService.adminEmail(email);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Admin>> delete(@RequestParam int id)
	{
		return adminService.adminDelete(id);
	}
	@PostMapping("/reset")
	public ResponseEntity<ResponseStructure<Admin>> resetPassword(@RequestParam String email,
			@RequestParam String newPassword, @RequestParam long phoneNumber)
	{
		return adminService.reset(email,newPassword,phoneNumber);
	}
 
}
