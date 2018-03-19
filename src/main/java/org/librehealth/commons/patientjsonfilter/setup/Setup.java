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
 * Component which is run at setup. It gets five patients from fhir server, one encounter
 * for each patient and 5 observations for each encounter then stores in the database
 */
@Component
public class Setup implements CommandLineRunner {

	@Autowired
	PatientRepository patientRepo;

	private String[] patientIds = Initialize.getIds();

	@Override
	public void run(String... strings) {

		System.out.println();
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		System.out.println("Hey");
		Initialize initialize = new Initialize();
		List<String> encounters = initialize.downloadEncounters();
		List<String> observations = initialize.downloadObservations();

		for (int i=0; i<patientIds.length; i++) {

			try{

				// Get patient
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

				System.out.println("Patient "+i+" is" + patient);
				System.out.println(encounters.size() + " As Encounter Size");
				System.out.println(observations.size() + " As Observation Size");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
