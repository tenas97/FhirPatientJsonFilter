package org.librehealth.commons.patientjsonfilter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String status;

	@ManyToOne
	@JoinColumn(name="ENTCOUNTER_ID", nullable=false)
	private Encounter encounter;

	public int getId() {
		return id;
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

	public Encounter getEncounter() {
		return this.encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

}
