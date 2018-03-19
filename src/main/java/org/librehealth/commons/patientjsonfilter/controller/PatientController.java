package org.librehealth.commons.patientjsonfilter.controller;

import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.librehealth.commons.patientjsonfilter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}

	@RequestMapping("/patients/{id}")
	public Patient getPatient(@PathVariable String id){
		return patientService.getPatient(id);
	}

}

