package org.librehealth.commons.patientjsonfilter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Encounter {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@JsonProperty("status")
	private String status;

	@ManyToOne
	@JoinColumn(name="PATIENT_ID", nullable=false)
	private Patient patient;


	@OneToMany(mappedBy = "encounter")
	private List<Observation> observations = new ArrayList<>();

	public Encounter() {

	}

	public int getId() {
		return id;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public void addObservation(Observation observation) {
		this.observations.add(observation);
	}
}

