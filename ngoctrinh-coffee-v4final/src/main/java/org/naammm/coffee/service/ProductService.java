package org.naammm.coffee.service;

import org.naammm.coffee.entity.Product;
import org.naammm.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void saveProduct(Product o) {
        productRepo.save(o); // save or update
    }

    public void deleteProduct(Product o) {
        productRepo.delete(o); // delete by id
    }
}
