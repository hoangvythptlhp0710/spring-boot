package com.learning.SpringBoot.repositories;

import com.learning.SpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
