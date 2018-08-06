package com.daniel.service;

import java.util.List;

import com.daniel.model.Product;

public interface ProductService {

	List<Product> listProduct() throws Exception;

	Product detailProduct(Long id) throws Exception;

	void updateProduct(Product vo);

	void deleteProduct(Long id);

}

