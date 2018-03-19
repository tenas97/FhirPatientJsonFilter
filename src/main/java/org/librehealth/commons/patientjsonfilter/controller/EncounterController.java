package org.librehealth.commons.patientjsonfilter.controller;

import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.librehealth.commons.patientjsonfilter.service.EncounterService;
import org.librehealth.commons.patientjsonfilter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {

		@Autowired
		private EncounterService encounterService;

		@RequestMapping("/patients/{id}/encounters")
		public List<Encounter> getAllPatients(@PathVariable int id){
			return encounterService.getAllPatientEncounters(id);
		}
		
}



