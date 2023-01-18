package com.group.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
