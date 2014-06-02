package com.healthycode.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.healthycode.dao.ProductDao;

@Service
public class ProductService{
	@Autowired
	private ProductDao productDao;
	public boolean addProduct(String name,String description,double price){
		return productDao.insert(name,description,price);
	}
}