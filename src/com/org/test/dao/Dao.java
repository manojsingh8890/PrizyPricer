package com.org.test.dao;

import java.util.List;

import com.org.test.beans.Product;

public interface Dao {
	
	public int saveData(Product p);
	
	public boolean saveOrUpdate(Product p);
	
	public List<Product> getProducts();
	
	public Product getProductById(String Barcode);
	
}
