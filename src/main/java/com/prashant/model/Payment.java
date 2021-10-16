package com.prashant.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int cardNumber;
	
	@JsonFormat(pattern = "MM/YY", shape = Shape.STRING)
	private String date;
	private int securityCode;
	private int postalCode;
	
	public Payment() {
		super();
	}
	public Payment(int id, String name, int cardNumber, String date, int securityCode, int postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.date = date;
		this.securityCode = securityCode;
		this.postalCode = postalCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	

}
