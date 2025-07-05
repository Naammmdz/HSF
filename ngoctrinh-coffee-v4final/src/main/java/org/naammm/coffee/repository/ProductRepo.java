package org.naammm.coffee.repository;

import org.naammm.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {

}
