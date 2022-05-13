package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
    public Product saveProduct(Product product) {
		return repository.save(product);   	
    }
    
    public List<Product> saveProducts(List<Product> products){
    	return repository.saveAll(products);
    }
    
    public List<Product> getProducts(){
    	return repository.findAll();
    }
    
    public Product getProductsById(int id){
    	return repository.findById(id).orElse(null);
    }
    
    public Product getProductsByName(String name){
    	return repository.findByName(name);
    }
    
    public String deleteProduct(int id) {
    	repository.deleteById(id);
    	return "Product has been Removed" +id;
    }
    
    public Product updateProduct(Product product) {
        Product extProduct = repository.findById(product.getId()).orElse(null);
        extProduct.setName(product.getName());
        extProduct.setQuantity(product.getQuantity());
        return repository.save(extProduct);
    }
}
