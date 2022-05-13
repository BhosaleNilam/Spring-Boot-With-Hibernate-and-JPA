package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/ProductData")
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return prodService.saveProduct(product);
		
	}
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return prodService.saveProducts(products);
		
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return prodService.getProducts();
		
	}
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return prodService.getProductsById(id);
		
	}

}
