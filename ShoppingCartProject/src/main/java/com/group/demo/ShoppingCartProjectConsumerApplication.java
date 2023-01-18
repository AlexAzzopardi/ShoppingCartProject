package com.group.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.group.entity.Order;
import com.group.entity.Product;
import com.group.entity.User;
import com.group.model.persistence.OrderDao;
import com.group.model.persistence.ProductBoughtDao;
import com.group.model.persistence.ProductDao;
import com.group.model.persistence.UserDao;

@SpringBootApplication(scanBasePackages = "com.group")
@EntityScan(basePackages = "com.group.entity")
@EnableJpaRepositories(basePackages = "com.group.model.persistence")
public class ShoppingCartProjectConsumerApplication implements CommandLineRunner{
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ProductBoughtDao productBoughtDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProjectConsumerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Order order1 = new Order(1, "Alex");
		orderDao.save(order1);
		
		User user1 = new User("Alex", "Azzopardi");
		userDao.save(user1);
		
		Product p1 = new Product(1, "Book1", 14, 3.4, "Book");
		Product p2 = new Product(2, "Book2", 10, 2.1, "Book");
		Product p3 = new Product(3, "CD1", 8, 1.4, "CD");
		Product p4 = new Product(4, "CD2", 5, 7.0, "CD");
		Product p5 = new Product(5, "Cosmetic1", 15, 8.0, "Cosmetic");
		Product p6 = new Product(6, "Cosmetic2", 7, 5.4, "Cosmetic");
		productDao.save(p1);
		productDao.save(p2);
		productDao.save(p3);
		productDao.save(p4);
		productDao.save(p5);
		productDao.save(p6);
		
//		ProductBought pb1 = new ProductBought(1, 2, 1);
//		ProductBought pb2 = new ProductBought(2, 4, 1);
//		ProductBought pb3 = new ProductBought(3, 8, 1);
//		ProductBought pb4 = new ProductBought(4, 3, 1);
//		ProductBought pb5 = new ProductBought(5, 9, 1);
//		ProductBought pb6 = new ProductBought(6, 10, 1);
//		productBoughtDao.save(pb1);
//		productBoughtDao.save(pb2);
//		productBoughtDao.save(pb3);
//		productBoughtDao.save(pb4);
//		productBoughtDao.save(pb5);
//		productBoughtDao.save(pb6);
		
	}
}
