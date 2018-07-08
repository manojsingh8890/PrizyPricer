package com.org.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.test.beans.Product;
import com.org.test.beans.ProductDesc;


public interface ProductService {
	
	public ProductDesc getProductDesc(Product product);
	
	 public double calcAveragePrice(List<Double> price);
	 
	 
	public double getLowestPrice(List<Double> price);
	
	
	public double getHighestPrice(List<Double> price);
	
	public double getIdealPrice(List<Double> price);
	
}
