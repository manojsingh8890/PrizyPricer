package com.org.test.beans;

public class ProductDesc {
    private int id;
	private String barCode;
	private String productDesc;
	private double AvgPrice;
	private double highestPrice;
	private double lowestPrice;
	private double idealPrice;
	
	
	public ProductDesc(int id , String barCode, String productDesc){
		this.id = id;
		this.barCode = barCode;
		this.productDesc = productDesc;
	}	
	
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}



	public double getAvgPrice() {
		return AvgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		AvgPrice = avgPrice;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public double getIdealPrice() {
		return idealPrice;
	}
	public void setIdealPrice(double idealPrice) {
		this.idealPrice = idealPrice;
	}
	
	
}
