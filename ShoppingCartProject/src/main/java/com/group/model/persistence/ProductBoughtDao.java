package com.group.model.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group.entity.ProductBought;

@Repository
public interface ProductBoughtDao extends JpaRepository<ProductBought, Integer> {
	
	public List<ProductBought> findAllByOrderId(int orderId);
	public ProductBought findByProductBoughtIdAndOrderId(int productBoughtId, int orderId);
	
	@Transactional
	@Modifying
	@Query("Update ProductBought set quantity=:quantity where productBoughtId=:productBoughtId")
	public int updateProductBoughtQuantity(@Param("productBoughtId") int pbId, @Param("quantity") int quantity);
	
	@Transactional
	@Modifying
	@Query(value = "insert into productBought values(:productBoughtId,:quantity,:orderId)",nativeQuery = true)
	public int insertProductBought(@Param("productBoughtId") int productBoughtId, @Param("orderId") int orderId, @Param("quantity") int quantity);

}
