package org.librehealth.commons.patientjsonfilter.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.librehealth.commons.patientjsonfilter.setup.ApacheHttpClientGet;

/**
 * Get Json representation of resources
 */
public class ResourceService {

	private final static String baseUrl = "http://hapi.fhir.org/baseDstu3";
	private final static ApacheHttpClientGet apacheHttpClientGet = new ApacheHttpClientGet();

	public static Patient getPatientById(String id) throws IOException {
		String json = apacheHttpClientGet.executeGet(baseUrl+"/Patient/"+id);
		return new ObjectMapper().readValue(json, Patient.class);
	}

	public static Encounter getEncounterById(String id) throws IOException {
		String json = apacheHttpClientGet.executeGet(baseUrl+"/Encounter/"+id);
		return new ObjectMapper().readValue(json, Encounter.class);
	}

	public static Observation getObservationById(String id)  throws IOException {
		String json = apacheHttpClientGet.executeGet(baseUrl+"/Observation/"+id);
		return new ObjectMapper().readValue(json, Observation.class);
	}

}
