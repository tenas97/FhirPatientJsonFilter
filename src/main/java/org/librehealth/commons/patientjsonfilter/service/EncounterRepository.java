package org.librehealth.commons.patientjsonfilter.service;

import org.librehealth.commons.patientjsonfilter.model.Encounter;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tenas on 3/18/18.
 */
public interface EncounterRepository extends CrudRepository<Encounter, String> {
	public Iterable<Encounter> findAllByPatientId(String id);
}
