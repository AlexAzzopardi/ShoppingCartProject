package com.group.model.service;

import java.util.List;

import com.group.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public Product getProductById(int productId);
	public Product addProduct(Product product);

}
