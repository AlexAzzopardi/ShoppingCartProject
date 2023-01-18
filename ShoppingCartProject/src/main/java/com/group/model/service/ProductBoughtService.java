package com.group.model.service;

import java.util.List;

import com.group.entity.ProductBought;

public interface ProductBoughtService {

	public List<ProductBought> getAllProductBought();
	public ProductBought getProductBoughtById(int productId);
	public List<ProductBought> getProductBoughtByOrderId(int orderId);
	public ProductBought getProductBoughtByIdAndOrderId(int productBoughtId, int orderId);
	public int getProductBoughtQuantity(int productBoughtId);
	public int updateProductBought(ProductBought productBought);
	public void deleteProductBoughtById(int productBoughtId);
}
