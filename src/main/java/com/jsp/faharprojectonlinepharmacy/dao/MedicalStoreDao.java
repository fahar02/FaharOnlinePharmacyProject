package com.jsp.faharprojectonlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.faharprojectonlinepharmacy.dto.MedicalStore;
import com.jsp.faharprojectonlinepharmacy.repo.MedicalStoreRepo;

@Repository
public class MedicalStoreDao {
	@Autowired
	private MedicalStoreRepo repo;
	public MedicalStore saveData(MedicalStore medicalStore)
	{
		return repo.save(medicalStore);
	}
	public MedicalStore updateData(int id, MedicalStore medicalStore)
	{
		Optional<MedicalStore> optional=repo.findById(id);
		if(optional.isPresent())
		{
			medicalStore.setStoreId(id);
			medicalStore.setAdmin(optional.get().getAdmin());
			medicalStore.setAddress(optional.get().getAddress());
			return repo.save(medicalStore);
		}
		else {
			return null;
		}
	}
	
	public MedicalStore findData(int id)
	{
		Optional<MedicalStore> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			return null;
		}
	}
	public MedicalStore deleteData(int id)
	{
		Optional<MedicalStore> optional=repo.findById(id);
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
