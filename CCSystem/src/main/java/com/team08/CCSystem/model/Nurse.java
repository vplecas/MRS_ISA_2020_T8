/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Veljko
 *
 */
@Entity
@Table(name = "Nurse")
public class Nurse extends User {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<Absence>();

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 * @param clinic
	 * @param absences
	 */
	public Nurse(Integer id, String email, String name, String surname, Address address, String phone, String password,
			Clinic clinic, Set<Absence> absences) {
		super(id, email, name, surname, address, phone, password);
//		this.clinic = clinic;
		this.absences = absences;
	}

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 */
	public Nurse(Integer id, String email, String name, String surname, Address address, String phone,
			String password) {
		super(id, email, name, surname, address, phone, password);
	}

//	public Clinic getClinic() {
//		return clinic;
//	}
//
//	public void setClinic(Clinic clinic) {
//		this.clinic = clinic;
//	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	
	
}