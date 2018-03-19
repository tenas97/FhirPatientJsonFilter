package org.librehealth.commons.patientjsonfilter.service;

import java.util.ArrayList;
import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncounterService {

		@Autowired
		private EncounterRepository encounterRepository;

		public List<Encounter> getAllPatientEncounters(String id){

			List<Encounter> encounter = new ArrayList<>();
			encounterRepository.findAllByPatientId(id).forEach(encounter::add);
			return encounter;
		}

	}


