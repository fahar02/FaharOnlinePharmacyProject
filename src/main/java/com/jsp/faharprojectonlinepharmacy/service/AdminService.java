package com.jsp.faharprojectonlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.faharprojectonlinepharmacy.dao.AdminDao;
import com.jsp.faharprojectonlinepharmacy.dto.Admin;
import com.jsp.faharprojectonlinepharmacy.exception.AdminEmailNotFoundException;
import com.jsp.faharprojectonlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.faharprojectonlinepharmacy.exception.AdminPhoneNumberNotValidException;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		Admin dbAdmin=adminDao.adminSave(admin);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("admin save successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbAdmin);
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id,Admin admin)
	{
		Admin dbAdmin=adminDao.adminUpdate(id,admin);
		if(dbAdmin!= null)
		{
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("admin update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
		    structure.setData(dbAdmin);
		    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		else {
			throw new AdminIdNotFoundException("Admin id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(int id)
	{
		Admin admin=adminDao.adminFind(id);
		if(admin!=null)
		{
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("admin update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
		    structure.setData(admin);
		    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		else {
			throw new AdminIdNotFoundException("Admin id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> adminEmail(String email)
	{
		Admin admin=adminDao.email(email);
		if(admin!=null)
		{
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("admin update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
		    structure.setData(admin);
		    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		else {
			throw new AdminEmailNotFoundException("Admin id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> adminDelete(int id)
	{
		Admin admin=adminDao.adminDelete(id);
		if(admin!=null)
		{
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("admin update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
		    structure.setData(admin);
		    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		else {
			throw new AdminIdNotFoundException("Admin id not found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Admin>> reset(String email,String password,long number)
	{
		Admin admin=adminDao.email(email);
		if(admin!=null)
		{
			if(admin.getPhoneNumber()==number)
			{
				admin.setPassword(password);
				adminDao.adminUpdate(admin.getAdminId(), admin);
				ResponseStructure<Admin> structure=new ResponseStructure<>();
				structure.setMessage("password update successfully");
				structure.setHttpStatus(HttpStatus.OK.value());
				structure.setData(admin);
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
			else {
				throw new AdminPhoneNumberNotValidException("phone number not found");
			}
			
		}
		else {
			throw new AdminEmailNotFoundException("Admin id not found");
			
		}
	}
 
}
