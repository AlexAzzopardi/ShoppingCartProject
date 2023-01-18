package com.group.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group.entity.Order;
import com.group.entity.Product;
import com.group.entity.ProductBought;
import com.group.model.service.OrderService;
import com.group.model.service.ProductBoughtService;
import com.group.model.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	ProductBoughtService productBoughtService;
	@Autowired
	ProductService productService;
	
	private int orderId = 1;

	List<String> getProductNames() {
		return productService.getAllProducts().stream()
		.map(Product::getProductName)
		.collect(Collectors.toList());
	}
	
    @RequestMapping("/menu")
    public ModelAndView showMainMenuController() {
        return new ModelAndView("MainMenu");
    }
	
    //ProductBought
	@RequestMapping("/productBuyMenu")
	public ModelAndView showProductMenuController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("productBought", new ProductBought());
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("ProductBuyMenu");
		return modelAndView;
	}

	//ProductBought
	@RequestMapping("/productBought")
	public ModelAndView productBoughtController(@ModelAttribute("command") ProductBought productBought) {
		System.out.println(orderId);
		productBought.setOrderId(orderId);
		productBoughtService.updateProductBought(productBought);
		ModelAndView modelAndView = showProductMenuController();
		modelAndView.addObject("added", "Product Added To Cart");
		return modelAndView;
	}
	
	//Order
	@RequestMapping("/viewBasket")
	public ModelAndView viewBasketController() {
		ModelAndView modelAndView=new ModelAndView();
		double totalPrice = orderService.getOrderPrice(orderId);
		modelAndView.addObject("productBought", new ProductBought());
		modelAndView.addObject("productBoughtList", productBoughtService.getProductBoughtByOrderId(orderId));
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.addObject("totalPrice", "Total: £" + new DecimalFormat("0.00").format(totalPrice));
		modelAndView.setViewName("ShowBasket");
		return modelAndView;
	}
	
	//Order
	@RequestMapping("/buyBasket")
	public ModelAndView buyBasketController() {
		ModelAndView modelAndView=new ModelAndView();
		orderId ++;
		orderService.addOrder(new Order(orderId, "Alex"));
		modelAndView.addObject("message", "Thank you for your purchase!");
		modelAndView.setViewName("Output");
		return modelAndView;
	}
	
	//ProductBought
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProductBoughtController(@ModelAttribute("command") ProductBought productBought) {
		productBoughtService.deleteProductBoughtById(productBought.getProductBoughtId());
		ModelAndView modelAndView=viewBasketController();
		modelAndView.addObject("removed", "Product Removed");
		return modelAndView;
	}
	
	@RequestMapping("/viewPreviousOrders")
	public ModelAndView viewPreviousController() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("orderList", orderService.getAllOrders());
		modelAndView.addObject("productBoughtList", productBoughtService.getAllProductBought());
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("PreviousOrders");
		return modelAndView;
	}
	
}
