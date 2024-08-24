package com.jsp.faharprojectonlinepharmacy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.faharprojectonlinepharmacy.dto.MedicalStore;
import com.jsp.faharprojectonlinepharmacy.service.MedicalStoreService;
import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;
@RestController
public class MedicalStoreController {
	@Autowired
	private MedicalStoreService medicalStoreSercvice;
	
	@PostMapping("/saveStore")
	public ResponseEntity<ResponseStructure<MedicalStore>> storeSave(@RequestBody MedicalStore medicalStore)
	{
		return medicalStoreSercvice.saveStore(medicalStore);
	}
	@PutMapping("/updateStore")
	public ResponseEntity<ResponseStructure<MedicalStore>> storeupdate(@RequestParam int id,@RequestBody MedicalStore medicalStore)
	{
		return medicalStoreSercvice.updateStore(id, medicalStore);
	}
	@GetMapping("/findStore")
	public ResponseEntity<ResponseStructure<MedicalStore>> storefind(@RequestParam int id)
	{
		return medicalStoreSercvice.findbyId(id);
	}
	@DeleteMapping("/deleteStore")
	public ResponseEntity<ResponseStructure<MedicalStore>> storedelete(@RequestParam int id)
	{
		return medicalStoreSercvice.deleteStore(id);
	}
 
}
