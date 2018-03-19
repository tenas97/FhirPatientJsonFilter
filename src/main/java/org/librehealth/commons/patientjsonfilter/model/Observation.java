package org.librehealth.commons.patientjsonfilter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation {

	@Id
	private String id;

	private String status;

	@JsonProperty("resourceType")
	private String resourceType;

	@ManyToOne
	@JoinColumn(name="patient", nullable=false)
	private Patient subject;

	@ManyToOne
	@JoinColumn(name="encounter", nullable=false)
	private Encounter encounter;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Encounter getEncounter() {
		return this.encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

}
