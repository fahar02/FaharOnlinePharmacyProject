package com.jsp.faharprojectonlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.faharprojectonlinepharmacy.dao.MedicalStoreDao;
import com.jsp.faharprojectonlinepharmacy.dto.MedicalStore;
import com.jsp.faharprojectonlinepharmacy.exception.MedicalStoreIdNotFound;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

@Service
public class MedicalStoreService {
	
	@Autowired
	private MedicalStoreDao medicalStoreDao;
	
	public ResponseEntity<ResponseStructure<MedicalStore>> saveStore(MedicalStore medicalStore)
	{
		MedicalStore dbMedicalStore=medicalStoreDao.saveData(medicalStore);
		ResponseStructure<MedicalStore> structure=new ResponseStructure<>();
		structure.setMessage("medical store save successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbMedicalStore);
		return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<MedicalStore>> updateStore(int id, MedicalStore medicalStore)
	{
		MedicalStore dbMedicalStore=medicalStoreDao.saveData(medicalStore);
		if(dbMedicalStore!=null)
		{
			ResponseStructure<MedicalStore> structure=new ResponseStructure<>();
			structure.setMessage("medical Store update Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbMedicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.OK);
		}
		else {
			throw new MedicalStoreIdNotFound("medical store Id not found");
		}
			
	}
	public ResponseEntity<ResponseStructure<MedicalStore>> findbyId(int id)
	{
		MedicalStore medicalStore=medicalStoreDao.findData(id);
		if(medicalStore!=null)
		{
			ResponseStructure<MedicalStore> structure=new ResponseStructure<>();
			structure.setMessage("medical Store update Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(medicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.OK);
		}
		else {
			throw new MedicalStoreIdNotFound("medical store Id not found");
		}
			
	}
	public ResponseEntity<ResponseStructure<MedicalStore>> deleteStore(int id)
	{
		MedicalStore medicalStore=medicalStoreDao.deleteData(id);
		if(medicalStore!=null)
		{
			ResponseStructure<MedicalStore> structure=new ResponseStructure<>();
			structure.setMessage("medical Store update Successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(medicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.OK);
		}
		else {
			throw new MedicalStoreIdNotFound("medical store Id not found");
		}
			
	}


}
