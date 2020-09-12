package com.alaa.product.category.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alaa.product.category.entity.ProductCategoryEntity;


public interface CategoryRepo  extends JpaRepository<ProductCategoryEntity, Integer> {

}
