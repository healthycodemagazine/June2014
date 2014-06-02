package com.healthycode.dao;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(String name,String description,double price){
		int rowsUpdated = jdbcTemplate.update("insert into product(name,description,price) values(?,?,?)",name,description,price);
		return rowsUpdated != 0;
	}	
}