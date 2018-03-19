package org.librehealth.commons.patientjsonfilter.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.HumanName;

@Entity
public class Name {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String text;

	private String family;

	private String use;

	@ManyToOne
	@JoinColumn(name="PATIENT_ID", nullable=false)
	private Patient patient;

	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> given = new ArrayList<>();

	public Name() {

	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<String> getGiven() {
		return given;
	}

	public void setGiven(List<String> given) {
		this.given = given;
	}
}
