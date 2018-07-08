package com.org.test.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="PRODUCTPRICE")
public class ProductPrice {
    
	
	@Column(name = "BARCODE")
	private String barcode;
   
	@Column(name = "PRICE")
	private double price;
	
    
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
     
     
}
