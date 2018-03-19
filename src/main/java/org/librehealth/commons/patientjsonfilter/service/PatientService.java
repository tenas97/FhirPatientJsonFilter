package org.librehealth.commons.patientjsonfilter.service;

import java.util.ArrayList;
import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatients(){

		List<Patient> patients = new ArrayList<>();
		patientRepository.findAll().forEach(patients::add);
		return patients;
	}

	public Patient getPatient(int id){
		return patientRepository.findById(id);
	}

}
