package com.group.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.entity.Order;
import com.group.entity.ProductBought;
import com.group.model.persistence.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	@Autowired
	ProductBoughtService productBoughtService;
	@Autowired
	ProductService productService;
	
	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}
	
	@Override
	public Order getOrderById(int orderId) {
		return orderDao.findById(orderId).orElse(null);
	}

	@Override
	public Order addOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public double getOrderPrice(int orderId) {
		double totalPrice = 0;
		List<ProductBought> productBoughtList = (List<ProductBought>) productBoughtService.getProductBoughtByOrderId(orderId);
		for (ProductBought productBought : productBoughtList) {
			totalPrice += productService.getProductById(productBought.getProductBoughtId()).getProductPrice() * productBought.getQuantity();
		}
		return totalPrice;
	}

}
