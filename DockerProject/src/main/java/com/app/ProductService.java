package com.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Get Product By Id
    public Product getProductById(Long id) {

        Optional<Product> optional = productRepo.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    // Delete Product By Id
    public boolean deleteProductById(Long id) {

        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }

        return false;
    }

    // Add New Product
    public Product addNewProduct(Product product) {

        return productRepo.save(product);
    }

    // Update Product
    public Product updateProduct(long id, Product product) {

        Optional<Product> optional = productRepo.findById(id);

        if (optional.isPresent()) {

            Product existingProduct = optional.get();

            // Update fields
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            
            return productRepo.save(existingProduct);
        }

        return null;
    }
}