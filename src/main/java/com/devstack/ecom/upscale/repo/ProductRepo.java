package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
}
