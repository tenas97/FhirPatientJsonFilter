package org.librehealth.commons.patientjsonfilter.service;

import org.librehealth.commons.patientjsonfilter.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {

}
