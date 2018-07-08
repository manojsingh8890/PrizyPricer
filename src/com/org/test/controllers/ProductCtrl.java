package com.org.test.controllers;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.org.test.beans.Product;
import com.org.test.beans.ProductDesc;
import com.org.test.service.ProductService;
import com.org.test.dao.Dao;

@Controller
public class ProductCtrl {

	@Autowired
	Dao dao;
	
	@Autowired
	ProductService productSev;
	
	
	@RequestMapping("/SaveProduct")
	public String saveProduct(@ModelAttribute("product") Product product){
		int id = 0;		
		try{			
			if((id = dao.saveData(product)) > 0){
				return "ProductFrm";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ProductFrm";
	}
	
	@RequestMapping("/GetProductList")
	public ModelAndView getProduct(){
		ModelAndView model = new ModelAndView("productViewer");
		model.addObject("products", dao.getProducts());			
		return model;
	}
	
	// Can be use library for direct conversion
	@RequestMapping(value ="/getProductDesc/{barcode}",  produces =  MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductById(@PathVariable("barcode")String barcode){
		 ProductDesc desc =  productSev.getProductDesc(dao.getProductById(barcode));
		 
		 net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
			jsonObject.put("id", desc.getId());
			jsonObject.put("Barcode", desc.getBarCode());
			jsonObject.put("HighestPrice", desc.getHighestPrice());
			jsonObject.put("IdealPrice", desc.getIdealPrice());
			jsonObject.put("LowestPrice", desc.getLowestPrice());
			jsonObject.put("ProductDesc", desc.getProductDesc());
			return jsonObject.toString();
		 
	}
	
	
	@RequestMapping("/ProdFrm")
	public ModelAndView saveProduct(){
		ModelAndView mdl = new ModelAndView("ProductFrm");
		return mdl;
	}
	
	
}
