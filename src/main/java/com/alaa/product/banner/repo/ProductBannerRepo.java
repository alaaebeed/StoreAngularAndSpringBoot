package com.alaa.product.banner.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alaa.product.banner.entity.ProductBannerEntity;
import com.alaa.product.category.entity.ProductCategoryEntity;

public interface ProductBannerRepo extends JpaRepository<ProductBannerEntity, Long>{

}
