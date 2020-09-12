package com.alaa.product.productRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.alaa.product.entity.ProductEntity;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

}
