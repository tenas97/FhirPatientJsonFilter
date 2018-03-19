package org.librehealth.commons.patientjsonfilter.controller;

import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.librehealth.commons.patientjsonfilter.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservationController {

		@Autowired
		private ObservationService observationService;

		@RequestMapping("/patients/{PatientId}/encounters/{id}/observations")
		public List<Observation> getAllPatients(@PathVariable Integer id){
			return observationService.getAllPatientObservations(id);
		}

	}



