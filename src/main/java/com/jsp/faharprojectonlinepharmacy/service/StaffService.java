package com.jsp.faharprojectonlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.faharprojectonlinepharmacy.dao.AdminDao;
import com.jsp.faharprojectonlinepharmacy.dao.MedicalStoreDao;
import com.jsp.faharprojectonlinepharmacy.dao.StaffDao;
import com.jsp.faharprojectonlinepharmacy.dto.Admin;
import com.jsp.faharprojectonlinepharmacy.dto.MedicalStore;
import com.jsp.faharprojectonlinepharmacy.dto.Staff;
import com.jsp.faharprojectonlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.faharprojectonlinepharmacy.exception.MedicalStoreIdNotFound;
import com.jsp.faharprojectonlinepharmacy.exception.StaffIdNotFound;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@Service
public class StaffService {
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private MedicalStoreDao medicalStoreDao;
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(int adminId,int storeId,Staff staff)
	{
		Admin admin=adminDao.adminFind(adminId);
		if(admin!=null)
		{
			staff.setAdmin(admin);
			MedicalStore medicalStore=medicalStoreDao.findData(storeId);
			if(medicalStore!=null)
			{
				staff.setMedicalStore(medicalStore);
				Staff staffdb=staffDao.saveData(staff);
				ResponseStructure<Staff> structure=new ResponseStructure<>();
				structure.setMessage("staff save successfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(staffdb);
				return new ResponseEntity<ResponseStructure<Staff>> (structure,HttpStatus.OK);
			}
			else {
				throw new MedicalStoreIdNotFound("store id not found");
			}
			
		
		}
		else {
			throw new AdminIdNotFoundException("admin id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(int id,Staff staff)
	{
		Staff dbStaff=staffDao.updateData(id,staff);
		if(dbStaff!=null)
		{
			ResponseStructure<Staff> structure=new ResponseStructure<>();
			structure.setMessage("staff update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>> (structure,HttpStatus.OK);
		}
		else {
			throw new StaffIdNotFound("store id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Staff>> findStaff(int id)
	{
		Staff dbStaff=staffDao.findData(id);
		if(dbStaff!=null)
		{
			ResponseStructure<Staff> structure=new ResponseStructure<>();
			structure.setMessage("staff update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>> (structure,HttpStatus.OK);
		}
		else {
			throw new StaffIdNotFound("store id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int id)
	{
		Staff dbStaff=staffDao.deleteData(id);
		if(dbStaff!=null)
		{
			ResponseStructure<Staff> structure=new ResponseStructure<>();
			structure.setMessage("staff update successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>> (structure,HttpStatus.OK);
		}
		else {
			throw new StaffIdNotFound("store id not found");
		}
		
	}

}
