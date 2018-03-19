package org.librehealth.commons.patientjsonfilter.setup;

import java.util.List;

import org.hl7.fhir.dstu3.model.HumanName;
import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Name;
import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.librehealth.commons.patientjsonfilter.service.PatientRepository;
import org.librehealth.commons.patientjsonfilter.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Setup is executed on startup. Gets 5 patient resources, 5 encounters per patient,
 * and 5 observations per encounter and saves it.
 */
@Component
public class Setup implements CommandLineRunner {

	@Autowired
	PatientRepository patientRepo;

	private String[] patientIds = Initialize.getIds();

	@Override
	public void run(String... strings) {

		Initialize initialize = new Initialize();
		List<String> encounters = initialize.downloadEncounters();
		List<String> observations = initialize.downloadObservations();

		for (int i=0; i<patientIds.length; i++) {

			try{

				Patient patient = ResourceService.getPatientById(patientIds[i]);
				for(Name name : patient.getName()){
					name.setPatient(patient);
				}

				for(int z=i*5; z<(i+1)*5; z++) {
					Encounter encounter = ResourceService.getEncounterById(encounters.get(z));
					encounter.setPatient(patient);
					for(int j=z*5; j<(z+1)*5; j++) {
						Observation observation = ResourceService.getObservationById(observations.get(j));
						observation.setEncounter(encounter);
						encounter.addObservation(observation);
					}

					patient.addEncounter(encounter);
				}

				patientRepo.save(patient);

				System.out.println("Done Saving Resource " + i+1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
