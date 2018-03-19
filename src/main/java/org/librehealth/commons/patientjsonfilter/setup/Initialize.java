package org.librehealth.commons.patientjsonfilter.setup;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.ReferenceClientParam;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Encounter;
import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.springframework.stereotype.Component;

@Component
public  class Initialize {

	private ApacheHttpClientGet apacheHttpClientGet = new ApacheHttpClientGet();

	private  static String[] ids = { "1250295", "726442", "1250080", "1249813", "1251166" };

	private List<String> observations = new ArrayList<>();

	private List<String> encounters = new ArrayList<>();

	private FhirContext ctx = FhirContext.forDstu3();

	private String serverBaseUrl = "http://hapi.fhir.org/baseDstu3";

	private IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);

	public Initialize() {

	}

	public static String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public  List<String> downloadEncounters() {

			for (String id: ids) {
				Bundle response = (Bundle) client.search().forResource(Encounter.class)
						.where(new ReferenceClientParam("patient").hasId(id))
						.prettyPrint()
						.limitTo(5)
						.execute();

				response.getEntry().forEach((entry) -> {
					encounters.add(entry.getResource().getId());
				});
			}
		System.out.println("Found " + encounters.size()
				+ " Encounters");
		return encounters;

	}

	public List<String> downloadObservations() {

		for (String id : ids) {
			Bundle response = (Bundle) client.search().forResource(org.hl7.fhir.dstu3.model.Observation.class)
					.where(new ReferenceClientParam("patient").hasId(id))
					.prettyPrint()
					.limitTo(25)
					.execute();

			response.getEntry().forEach((entry) -> {
				observations.add(entry.getResource().getId());
			});
		}
		System.out.println("Found " + observations.size()
				+ " Observations");
		return observations;
	}

}

