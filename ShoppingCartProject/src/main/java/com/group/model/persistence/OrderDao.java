package com.group.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	
}
