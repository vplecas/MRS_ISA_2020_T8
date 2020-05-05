package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ClinicalCenter")
public class ClinicalCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clinic> clinics = new HashSet<Clinic>();
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patient> patients = new HashSet<>();
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicalCenterAdmin> admins = new HashSet<>();

	/**
	 * @param id
	 * @param name
	 * @param clinics
	 * @param patients
	 * @param admins
	 */
	public ClinicalCenter(Long id, String name, Set<Clinic> clinics, Set<Patient> patients,
			Set<ClinicalCenterAdmin> admins) {
		super();
		this.id = id;
		this.name = name;
		this.clinics = clinics;
		this.patients = patients;
		this.admins = admins;
	}

	/**
	 * 
	 */
	public ClinicalCenter() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(Set<Clinic> clinics) {
		this.clinics = clinics;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Set<ClinicalCenterAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<ClinicalCenterAdmin> admins) {
		this.admins = admins;
	}
	
}
