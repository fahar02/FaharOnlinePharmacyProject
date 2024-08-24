package com.jsp.faharprojectonlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.faharprojectonlinepharmacy.dto.Admin;
import com.jsp.faharprojectonlinepharmacy.repo.AdminRepo;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin adminSave(Admin admin)
	{
		return adminRepo.save(admin);
	}
	
	public Admin adminUpdate(int id, Admin admin)
	{
		Optional<Admin> optional=adminRepo.findById(id);
		if(optional.isPresent())
		{
			admin.setAdminId(id);
		return 	adminRepo.save(admin);
		}
		return null;
	}
	public Admin adminFind(int id)
	{
		Optional<Admin> optional=adminRepo.findById(id);
		if(optional.isPresent())
		{
			
		return 	optional.get();
		}
		return null;
	}
	public Admin email(String email)
	{
		Optional<Admin> optional=adminRepo.findByEmail(email);
		if(optional.isPresent())
		{
		return 	optional.get();
		}
		return null;
		
	}
	public Admin adminDelete(int id)
	{
		Optional<Admin> optional=adminRepo.findById(id);
		if(optional.isPresent())
		{
			adminRepo.delete(optional.get());
		return 	optional.get();
		}
		return null;
	}


}
