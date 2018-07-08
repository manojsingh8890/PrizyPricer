package com.org.test.beans;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	int id;
	
	@Column(name = "STORE")
	private String store;
	
	@Column(name = "BARCODE")
	private String barcode;
	
	
	@ElementCollection
    @CollectionTable(name="PRODUCTPRICE", joinColumns=@JoinColumn(name="id"))
	@Column(name="PRICE")
	private List<Double> price;
	
	public int getId() {		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String note;

	public List<Double> getPrice() {
		return price;
	}
	public void setPrice(List<Double> price) {
		this.price = price;
	}	
}
