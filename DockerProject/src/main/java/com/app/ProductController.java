package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProductById(@PathVariable long id) {
		return productService.deleteProductById(id);
	}
	
	@PostMapping
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product, long id ) {
		return productService.updateProduct(id, product);		
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
}
