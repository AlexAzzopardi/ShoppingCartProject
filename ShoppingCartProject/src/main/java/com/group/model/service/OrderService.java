package com.group.model.service;

import java.util.List;

import com.group.entity.Order;

public interface OrderService {

	public List<Order> getAllOrders();
	public Order getOrderById(int orderId);
	public Order addOrder(Order order);
	public double getOrderPrice(int orderId);

}
