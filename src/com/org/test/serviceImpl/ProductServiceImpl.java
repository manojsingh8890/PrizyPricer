package com.org.test.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.test.beans.Product;
import com.org.test.beans.ProductDesc;
import com.org.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	public ProductDesc getProductDesc(Product product){
		ProductDesc desc = new ProductDesc(product.getId(), product.getBarcode(), product.getNote());
		desc.setAvgPrice(calcAveragePrice(product.getPrice()));
		desc.setLowestPrice(getLowestPrice(product.getPrice()));
		desc.setHighestPrice(getHighestPrice(product.getPrice()));
		desc.setIdealPrice(getIdealPrice(product.getPrice()));
		
		return desc;		
	}
	
	 public double calcAveragePrice(List<Double> price) {
		   Double  d1 = 0.0;
	        for(Double d : price) {
	            d1 = d1+d;
	        }	 
	       return d1/price.size(); 
	}
	 
	 
	public double getLowestPrice(List<Double> price){		
	  if(price != null && !price.isEmpty()) {
	    Collections.sort(price);
	    return price.get(0);
	  }
	  
	  return 0;
	}
	
	
	public double getHighestPrice(List<Double> price){		
		  if(price != null && !price.isEmpty()) {
		    Collections.sort(price, Collections.reverseOrder());
		    return price.get(0);
		  }
		  
		  return 0;
    }
	
	
	public double getIdealPrice(List<Double> price){		
		 Collections.sort(price, Collections.reverseOrder());		 
		 price.remove(0);
		 price.remove(0);
		 price.remove(price.size()-1);
		 price.remove(price.size()-1);		  
		 double dbl = calcAveragePrice(price);
		 dbl = dbl+ (dbl*20/100);
		 return dbl;
		 
    }
	
}
