package com.nz.tsb.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/*
 * Aaron test TSB_API Test
 * 18/07/2021
 * •	The vehicle listing resource should contain the following properties: 
o	Registration (mandatory)
o	Year
o	Make
o	Model
o	Colour 
o	Price

 */

@Table(name = "vehicle")
@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(name = "registraion", nullable = false, updatable = false)
	private Date registration;

	@UpdateTimestamp
	@Column(name = "updatedTime")
	private Date updatedTime;

	@Column(name = "year")
	private Integer year;

	@Column(name = "mark")
	private String mark;

	@Column(name = "model")
	private String model;

	@Column(name = "colour")
	private String colour;

	@Column(name = "price")
	private Integer price;

	public Vehicle() {

	}

	public Vehicle(Integer year, String mark, String model, String colour, Integer price) {
		super();
		this.year = year;
		this.mark = mark;
		this.model = model;
		this.colour = colour;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
