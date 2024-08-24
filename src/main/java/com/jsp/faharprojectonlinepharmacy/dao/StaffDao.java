package com.jsp.faharprojectonlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.faharprojectonlinepharmacy.dto.Staff;
import com.jsp.faharprojectonlinepharmacy.repo.StaffRepo;

@Repository
public class StaffDao {
	
	@Autowired
	private StaffRepo repo;
	
	public Staff saveData(Staff staff)
	{
		return repo.save(staff);
	}
	public Staff updateData(int id,Staff staff)
	{
		Optional<Staff> optional=repo.findById(id);
		if(optional.isPresent())
		{
			staff.setStaffId(id);
			staff.setAdmin(optional.get().getAdmin());
			staff.setMedicalStore(optional.get().getMedicalStore());
			return repo.save(staff);
		}
		else {
			return null;
		}
	}
	public Staff findData(int id)
	{
		Optional<Staff> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			return null;
		}
	}
	public Staff deleteData(int id)
	{
		Optional<Staff> optional=repo.findById(id);
		if(optional.isPresent())
		{
			repo.delete(optional.get());
			return optional.get();
		}
		else {
			return null;
		}
	}
	

}
