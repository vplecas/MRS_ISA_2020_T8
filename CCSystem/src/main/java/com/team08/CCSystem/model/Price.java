/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 * This class is actually ExaminationType from price list.
 */
@Entity
@SQLDelete(sql = "UPDATE price SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "Price")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Clinic clinic;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ExaminationType examinationType;
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param price
	 * @param examinationType
	 */
	public Price(Long id, double price, ExaminationType examinationType) {
		super();
		this.id = id;
		this.price = price;
		this.examinationType = examinationType;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Price() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
}
