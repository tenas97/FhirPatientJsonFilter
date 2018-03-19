package org.librehealth.commons.patientjsonfilter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

	@Id
	private String id;

	private boolean active = true;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("birthDate")
	private Date birthDate;

	private Boolean deceasedBoolean = false;

	@JsonProperty("name")
	@JsonIgnoreProperties("patient")
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Name> name = new ArrayList<>();

	@JsonIgnoreProperties("patient")
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Encounter> encounters = new ArrayList<>();

	public Patient() {
	}

	public List<Name> getName() {
		return name;
	}

	public void setName(List<Name> name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public void addEncounter(Encounter encounter) {
		encounters.add(encounter);
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getDeceasedBoolean() {
		return deceasedBoolean;
	}

	public void setDeceasedBoolean(Boolean deceasedBoolean) {
		this.deceasedBoolean = deceasedBoolean;
	}

}
