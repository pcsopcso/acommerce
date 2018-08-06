package com.daniel.dao;

import java.util.List;

import com.daniel.model.Product;

public interface ProductDao {

	public int create (Product product)throws Exception;
	
	public int update(Product product)throws Exception;
	
	public int delete(Long id)throws Exception;
	
	public Product findById(Long id)throws Exception;
	
	public List<Product> findAll()throws Exception;
}
