package org.librehealth.commons.patientjsonfilter.service;

import java.util.ArrayList;
import java.util.List;

import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {

		@Autowired
		private ObservationRepository observationRepository;

		public List<Observation> getAllPatientObservations(int id){

			List<Observation> observation = new ArrayList<>();
			observationRepository.findAllByEncounterId(id).forEach(observation::add);
			return observation;
		}

	}




