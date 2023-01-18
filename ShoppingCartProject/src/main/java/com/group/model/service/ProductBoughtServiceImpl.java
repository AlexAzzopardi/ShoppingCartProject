package com.group.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.entity.ProductBought;
import com.group.model.persistence.ProductBoughtDao;

@Service
public class ProductBoughtServiceImpl implements ProductBoughtService {
	
	@Autowired
	ProductBoughtDao productBoughtDao;
	
	@Override
	public List<ProductBought> getAllProductBought() {
		return productBoughtDao.findAll();
	}
	
	@Override
	public ProductBought getProductBoughtById(int productBoughtId) {
		return productBoughtDao.findById(productBoughtId).orElse(null);
	}
	
	@Override
	public List<ProductBought> getProductBoughtByOrderId(int orderId) {
		return productBoughtDao.findAllByOrderId(orderId);
	}

	@Override
	public ProductBought getProductBoughtByIdAndOrderId(int productBoughtId, int orderId) {
		return productBoughtDao.findByProductBoughtIdAndOrderId(productBoughtId, orderId);
	}

	@Override
	public int getProductBoughtQuantity(int productBoughtId) {
		return productBoughtDao.findById(productBoughtId).orElse(null).getQuantity();
	}

	@Override
	public int updateProductBought(ProductBought productBought) {
		ProductBought pb = productBoughtDao.findByProductBoughtIdAndOrderId(productBought.getProductBoughtId(), productBought.getOrderId());
		if(pb == null)
			return productBoughtDao.insertProductBought(productBought.getProductBoughtId(), productBought.getQuantity(), productBought.getOrderId());
		else
			return productBoughtDao.updateProductBoughtQuantity(productBought.getProductBoughtId(), pb.getQuantity()+ productBought.getQuantity());
	}
	
	public void deleteProductBoughtById(int productBoughtId) {
		productBoughtDao.deleteById(productBoughtId);
	}
	

}
