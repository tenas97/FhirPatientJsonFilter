package org.librehealth.commons.patientjsonfilter.service;

import org.librehealth.commons.patientjsonfilter.model.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ObservationRepository extends CrudRepository<Observation, String> {
	public Iterable<Observation> findAllByEncounterId(@Param("q") int id);

}
